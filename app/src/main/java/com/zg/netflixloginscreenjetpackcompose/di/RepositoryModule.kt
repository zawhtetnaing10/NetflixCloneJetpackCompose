package com.zg.netflixloginscreenjetpackcompose.di

import com.zg.netflixloginscreenjetpackcompose.data.repository.MovieDataRepository
import com.zg.netflixloginscreenjetpackcompose.firebase.FirebaseCredentialProvider
import com.zg.netflixloginscreenjetpackcompose.network.MoviesApi
import com.zg.netflixloginscreenjetpackcompose.persistence.DataStoreUtils
import com.zg.netflixloginscreenjetpackcompose.persistence.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun getMovieRepository(
        dataStoreUtils: DataStoreUtils,
        credentialProvider: FirebaseCredentialProvider,
        moviesApi: MoviesApi,
        movieDatabase: AppDatabase
    ): MovieDataRepository {
        return MovieDataRepository(dataStoreUtils, credentialProvider, moviesApi, movieDatabase)
    }
}