package com.zg.netflixloginscreenjetpackcompose.di

import com.zg.netflixloginscreenjetpackcompose.data.repository.MovieDataRepository
import com.zg.netflixloginscreenjetpackcompose.firebase.FirebaseCredentialProvider
import com.zg.netflixloginscreenjetpackcompose.network.MoviesApi
import com.zg.netflixloginscreenjetpackcompose.persistence.DataStoreUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun getMovieRepository(dataStoreUtils: DataStoreUtils, credentialProvider: FirebaseCredentialProvider, moviesApi: MoviesApi): MovieDataRepository {
        return MovieDataRepository(dataStoreUtils, credentialProvider, moviesApi)
    }
}