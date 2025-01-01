package com.zg.netflixloginscreenjetpackcompose.di

import com.zg.netflixloginscreenjetpackcompose.firebase.FirebaseCredentialProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideFirebaseCredentialProvider(): FirebaseCredentialProvider {
        return FirebaseCredentialProvider()
    }
}