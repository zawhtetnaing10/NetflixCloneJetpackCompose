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

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideFirebaseCredentialProvider(): FirebaseCredentialProvider {
        return FirebaseCredentialProvider()
    }

    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(universalJsonConverter.asConverterFactory("application/json;charset=UTF8".toMediaType()))
            .build()
    }

    @Provides
    fun provideMovieApi(retrofit : Retrofit) : MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }
}