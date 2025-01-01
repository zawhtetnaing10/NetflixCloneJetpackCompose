package com.zg.netflixloginscreenjetpackcompose.data.repository

import com.zg.netflixloginscreenjetpackcompose.firebase.FirebaseCredentialProvider
import com.zg.netflixloginscreenjetpackcompose.persistence.DataStoreUtils
import javax.inject.Inject

/**
 * Data repository for the app
 * Communicates with both Network and Persistence Layers
 */
class MovieDataRepository @Inject constructor(
    private val dataStoreUtils: DataStoreUtils,
    private val firebaseCredentialProvider: FirebaseCredentialProvider
) {
    /**
     * Fetches the api key from the DataStore
     * If the api key stored in DataStore is empty, fetch it from CloudFirestore and save it into DataStore
     * Then return the apiKey.
     */
    private fun getApiKey() {
        // TODO: - Continue implementing this after setting up Flow for DataStore and FirebaseCredentialProvider
        dataStoreUtils.apiKey
    }
}