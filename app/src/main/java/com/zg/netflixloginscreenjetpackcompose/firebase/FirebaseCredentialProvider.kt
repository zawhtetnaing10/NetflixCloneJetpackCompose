package com.zg.netflixloginscreenjetpackcompose.firebase

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class FirebaseCredentialProvider {
    // Instance of FireStore
    val db = Firebase.firestore

    /**
     * Gets theMovieDB api key from cloud fire store
     */
    fun getMovieDBApiKey(): Flow<String?> {
        return flow<String> {
            val apiKey = db.collection(API_KEYS_COLLECTION_NAME)
                .document(MOVIE_DB_DOCUMENT_NAME)
                .get()
                .await()
                .get(API_KEY_ATTRIBUTE_NAME) as? String
            apiKey?.let {
                emit(it)
            } ?: run {
                throw IllegalStateException("Api key not found")
            }
        }
    }
}