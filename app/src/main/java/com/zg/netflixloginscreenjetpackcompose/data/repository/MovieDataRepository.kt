package com.zg.netflixloginscreenjetpackcompose.data.repository

import com.zg.netflixloginscreenjetpackcompose.data.models.Movie
import com.zg.netflixloginscreenjetpackcompose.firebase.FirebaseCredentialProvider
import com.zg.netflixloginscreenjetpackcompose.network.MoviesApi
import com.zg.netflixloginscreenjetpackcompose.persistence.DataStoreUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
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
    private val moviesApi: MoviesApi
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

    // TODO: - This flow is not completing. Need to find out why.
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
     * Fetches the api key from the DataStore
     * If the api key stored in DataStore is empty, fetch it from CloudFirestore and save it into DataStore
     * Then return the apiKey.
     */
    private fun getApiKey(): Flow<String> {
        return flow{ emit (dataStoreUtils.getApiKeyFromDataStore()) }
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
                return@flatMapLatest flowOf(it ?: "")
            }
    }
}