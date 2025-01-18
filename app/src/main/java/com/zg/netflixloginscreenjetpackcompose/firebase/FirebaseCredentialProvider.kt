package com.zg.netflixloginscreenjetpackcompose.firebase

import com.google.firebase.firestore.dataObjects
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.channels.awaitClose

class FirebaseCredentialProvider {
    // Instance of FireStore
    val db = Firebase.firestore

    /**
     * Gets theMovieDB api key from cloud fire store
     */
    fun getMovieDBApiKey(): Flow<String?> {
        return callbackFlow {
            db.collection(API_KEYS_COLLECTION_NAME)
                .document(MOVIE_DB_DOCUMENT_NAME)
                .get()
                .addOnSuccessListener { snapShot ->
                    val apiKey = snapShot.get(API_KEY_ATTRIBUTE_NAME) as? String
                    apiKey?.let {
                        trySend(it)
                        close()
                    } ?: run {
                        throw IllegalStateException("Api key not found")
                    }
                }
                .addOnFailureListener { exception ->
                    close(exception)
                }
            awaitClose {}
        }
    }
}