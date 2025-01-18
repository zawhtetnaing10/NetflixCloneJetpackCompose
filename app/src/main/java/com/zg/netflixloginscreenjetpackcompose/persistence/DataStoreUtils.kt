package com.zg.netflixloginscreenjetpackcompose.persistence

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Name of the DataStore
 */
const val MOVIE_DATA_STORE_NAME = "moviedb_data_store"

/**
 * Data Store instance which will be used for storing key value data
 */
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = MOVIE_DATA_STORE_NAME)

/**
 * This class will be used by the Repository to store and retrieve key value data from persistence
 */
class DataStoreUtils @Inject constructor(@ApplicationContext context: Context) {
    /**
     * Initialize Data store
     */
    private val dataStore = context.dataStore

    /**
     * Keys for Data Store
     */
    private val kMovieDbApiKey = stringPreferencesKey("movie_db_api_key")


    /**
     * Retrieves the data store from db
     */
    suspend fun getApiKeyFromDataStore(): String {
        return dataStore.data.map { preferences ->
            preferences[kMovieDbApiKey] ?: ""
        }.first()
    }

    /**
     * Saves api key to the data store
     * @param apiKey new apiKey to be saved
     */
    suspend fun saveApiKey(apiKey: String) {
        dataStore.edit { it[kMovieDbApiKey] = apiKey }
    }
}