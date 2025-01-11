package com.zg.netflixloginscreenjetpackcompose.data.repository

import com.zg.netflixloginscreenjetpackcompose.data.models.Movie
import com.zg.netflixloginscreenjetpackcompose.firebase.FirebaseCredentialProvider
import com.zg.netflixloginscreenjetpackcompose.network.MoviesApi
import com.zg.netflixloginscreenjetpackcompose.persistence.DataStoreUtils
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
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
    fun getNowPlayingMovies(): Flow<List<Movie>?> {
        return getApiKey()
            .map { moviesApi.getNowPlayingMovies(authorization = it, page = 1.toString()) }
            .map { it.movieList }
    }

    /**
     * Fetches the api key from the DataStore
     * If the api key stored in DataStore is empty, fetch it from CloudFirestore and save it into DataStore
     * Then return the apiKey.
     */
    private fun getApiKey(): Flow<String> {
        return dataStoreUtils.apiKey
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
                dataStoreUtils.saveApiKey(it)
                return@flatMapLatest flowOf(it)
            }
    }
}