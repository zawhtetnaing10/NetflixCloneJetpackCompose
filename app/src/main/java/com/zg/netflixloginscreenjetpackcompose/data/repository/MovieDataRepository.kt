package com.zg.netflixloginscreenjetpackcompose.data.repository

import android.util.Log
import androidx.room.withTransaction
import com.zg.netflixloginscreenjetpackcompose.data.models.Genre
import com.zg.netflixloginscreenjetpackcompose.data.models.Movie
import com.zg.netflixloginscreenjetpackcompose.data.models.TrailerVideo
import com.zg.netflixloginscreenjetpackcompose.firebase.FirebaseCredentialProvider
import com.zg.netflixloginscreenjetpackcompose.network.MoviesApi
import com.zg.netflixloginscreenjetpackcompose.network.responses.CreditResponse
import com.zg.netflixloginscreenjetpackcompose.persistence.DataStoreUtils
import com.zg.netflixloginscreenjetpackcompose.persistence.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

/**
 * Data repository for the app
 * Communicates with both Network and Persistence Layers
 */
@OptIn(ExperimentalCoroutinesApi::class)
class MovieDataRepository @Inject constructor(
    private val dataStoreUtils: DataStoreUtils,
    private val firebaseCredentialProvider: FirebaseCredentialProvider,
    private val moviesApi: MoviesApi,
    private val movieDatabase: AppDatabase,
) {

    /**
     * Get now playing movies from network
     * @return Returns the Flow of the movie list obtained
     */
    fun fetchFeaturedMovie(): Flow<Movie?> {
        return getApiKey()
            .flatMapLatest(::fetchFeaturedMovieFlow)
            .flowOn(Dispatchers.IO)
    }

    /**
     * Fetch movies for Continue Watching
     */
    fun fetchContinueWatchingMoviesFlow(): Flow<List<Movie>> {
        return movieDatabase.movieDao().getMoviesForContinueWatching()
    }

    /**
     * Fetches Featured Movie
     */
    fun fetchFeaturedMovieFlow(apiKey: String): Flow<Movie?> = flow {
        val nowPlayingMovies = moviesApi.getNowPlayingMovies(authorization = apiKey, page = 1.toString()).movieList
        if (nowPlayingMovies?.isNotEmpty() == true) {
            val featuredMovie = nowPlayingMovies.first()
            val featuredMovieDetails = moviesApi.getMovieDetails(authorization = apiKey, movieId = featuredMovie.id!!)
            emit(featuredMovieDetails)
        } else {
            emit(null)
        }
    }

    fun fetchMoviesByGenre(): Flow<Pair<String, List<Movie>>> {
        return getApiKey()
            .flatMapLatest(::fetchMoviesByGenreFlow)
            .flowOn(Dispatchers.IO)
    }

    fun fetchMoviesByGenreFlow(apiKey: String): Flow<Pair<String, List<Movie>>> {
        return flow { emit(moviesApi.getGenres(apiKey)) }
            .map { it.genres }
            .flatMapMerge { it.asFlow() }
            .transform {
                val moviesByGenre = moviesApi.getMoviesByGenre(authorization = apiKey, genreId = it.id).movieList ?: listOf()
                emit(Pair(it.name, moviesByGenre))
            }
    }

    /**
     * Wrapper for fetchMoviesByGenreListFlow function together with getApiKey flow
     * Will be called from ViewModel.
     */
    fun fetchMoviesByGenreList(genreList: List<Genre>): Flow<List<Movie>> {
        return getApiKey()
            .flatMapLatest { fetchMoviesByGenreListFlow(apiKey = it, genreList = genreList) }
            .flowOn(Dispatchers.IO)
    }

    /**
     * Fetches Movies By a given genre list
     */
    private fun fetchMoviesByGenreListFlow(apiKey: String, genreList: List<Genre>): Flow<List<Movie>> {
        return genreList.asFlow()
            .transform {
                val moviesByGenre = moviesApi.getMoviesByGenre(authorization = apiKey, genreId = it.id).movieList ?: listOf()
                emit(moviesByGenre)
            }
    }

    /**
     * Fetch movie details from network.
     */
    fun fetchMovieDetails(movieId: Int): Flow<Movie?> {
        return getApiKey()
            .transform { emit(moviesApi.getMovieDetails(authorization = it, movieId = movieId)) }
            .flowOn(Dispatchers.IO)
    }

    /**
     * Mark movie as Continue Watching
     */
    suspend fun markMovieAsContinueWatching(movie: Movie) {
        movie.continueWatching = 1
        movieDatabase.movieDao().saveSingleMovie(movie)
    }

    /**
     * Get credits by movie.
     * @param movieId The id of the movie to get the credits
     * @return Credits including cast and crew for the movie.
     */
    fun fetchCreditsByMovie(movieId: Int): Flow<CreditResponse> {
        return getApiKey()
            .transform { emit(moviesApi.getCreditsByMovie(authorization = it, movieId = movieId)) }
            .flowOn(Dispatchers.IO)
    }

    /**
     * Fetches trailer for a movie
     * First it maps the response into the video list
     * Then it flatMaps each video into a flow
     * Then it filters out the "Youtube" videos
     * Then takes the first one.
     */
    fun fetchTrailerForMovie(movieId: Int): Flow<TrailerVideo?> {
        return getApiKey()
            .transform { emit(moviesApi.getVideos(authorization = it, movieId = movieId)) }
            .map { it.results }
            .flatMapConcat { it.asFlow() }
            .filter { it.isYoutubeVideo() }
            .take(1)
    }

    /**
     * Fetches the api key from the DataStore
     * If the api key stored in DataStore is empty, fetch it from CloudFirestore and save it into DataStore
     * Then return the apiKey.
     */
    private fun getApiKey(): Flow<String> {
        return flow { emit(dataStoreUtils.getApiKeyFromDataStore()) }
            .flatMapLatest {
                if (it.isNotBlank())
                    flowOf("Bearer $it")
                else
                    getApiKeyFromFirebaseAndSaveToDataStore()
            }
    }

    /**
     * Fetch the api key from Cloud Firestore and save to DataStore
     * @return Flow of the api key fetched from Cloud Firestore
     */
    private fun getApiKeyFromFirebaseAndSaveToDataStore(): Flow<String> {
        return firebaseCredentialProvider.getMovieDBApiKey()
            .flatMapLatest {
                dataStoreUtils.saveApiKey(it ?: "")
                return@flatMapLatest flowOf("Bearer $it")
            }
    }
}