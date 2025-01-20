package com.zg.netflixloginscreenjetpackcompose.di

import android.content.Context
import androidx.room.Room
import com.zg.netflixloginscreenjetpackcompose.persistence.DataStoreUtils
import com.zg.netflixloginscreenjetpackcompose.persistence.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    fun provideDataStoreUtils(@ApplicationContext context: Context): DataStoreUtils {
        return DataStoreUtils(context = context)
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "netflix_database")
            .fallbackToDestructiveMigration()
            .build()
    }
}