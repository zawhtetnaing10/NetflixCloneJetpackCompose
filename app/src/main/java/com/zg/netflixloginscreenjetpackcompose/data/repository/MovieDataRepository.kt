package com.zg.netflixloginscreenjetpackcompose.data.repository

import com.zg.netflixloginscreenjetpackcompose.firebase.FirebaseCredentialProvider
import com.zg.netflixloginscreenjetpackcompose.persistence.DataStoreUtils
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

/**
 * Data repository for the app
 * Communicates with both Network and Persistence Layers
 */
@OptIn(ExperimentalCoroutinesApi::class)
class MovieDataRepository @Inject constructor(
    private val dataStoreUtils: DataStoreUtils,
    private val firebaseCredentialProvider: FirebaseCredentialProvider
) {

    // TODO: - Continue implementing this
    fun getNowPlayingMovies() : Flow<String>{
        return getApiKey()
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
                    flowOf(it)
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