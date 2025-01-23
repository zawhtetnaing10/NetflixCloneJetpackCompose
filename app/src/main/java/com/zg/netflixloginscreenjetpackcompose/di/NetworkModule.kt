package com.zg.netflixloginscreenjetpackcompose.di

import com.zg.netflixloginscreenjetpackcompose.firebase.FirebaseCredentialProvider
import com.zg.netflixloginscreenjetpackcompose.network.BASE_URL
import com.zg.netflixloginscreenjetpackcompose.network.MoviesApi
import com.zg.netflixloginscreenjetpackcompose.utils.universalJsonConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideFirebaseCredentialProvider(): FirebaseCredentialProvider {
        return FirebaseCredentialProvider()
    }

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(universalJsonConverter.asConverterFactory("application/json;charset=UTF8".toMediaType()))
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieApi(retrofit : Retrofit) : MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }
}