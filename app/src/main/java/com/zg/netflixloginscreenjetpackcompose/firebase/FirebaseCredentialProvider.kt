package com.zg.netflixloginscreenjetpackcompose.firebase

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FirebaseCredentialProvider {
    // Instance of FireStore
    val db = Firebase.firestore

    /**
     * Gets theMovieDB api key from cloud fire store
     * @param onSuccess Callback if the api key retrieval is successful
     * @param onFailure Callback if the api key retrieval failed.
     */
    fun getMovieDBApiKey(onSuccess: (String) -> Unit, onFailure: () -> Unit) {
        db.collection(API_KEYS_COLLECTION_NAME)
            .document(MOVIE_DB_DOCUMENT_NAME)
            .get()
            .addOnSuccessListener {
                val apiKey = it.get(API_KEY_ATTRIBUTE_NAME).toString()
                Log.d("ApiKey", apiKey)
                onSuccess(apiKey)
            }
            .addOnFailureListener {
                Log.d("ApiKey", "Failed to retrieve api key")
                onFailure()
            }
    }
}