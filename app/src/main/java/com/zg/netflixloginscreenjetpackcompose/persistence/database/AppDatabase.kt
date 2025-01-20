package com.zg.netflixloginscreenjetpackcompose.persistence.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zg.netflixloginscreenjetpackcompose.data.models.Movie
import com.zg.netflixloginscreenjetpackcompose.persistence.daos.MovieDao
import com.zg.netflixloginscreenjetpackcompose.persistence.type_converters.CollectionInfoTypeConverter
import com.zg.netflixloginscreenjetpackcompose.persistence.type_converters.GenreListTypeConverter
import com.zg.netflixloginscreenjetpackcompose.persistence.type_converters.OriginCountryTypeConverter
import com.zg.netflixloginscreenjetpackcompose.persistence.type_converters.ProductionCompanyListTypeConverter
import com.zg.netflixloginscreenjetpackcompose.persistence.type_converters.ProductionCountryListTypeConverter
import com.zg.netflixloginscreenjetpackcompose.persistence.type_converters.SpokenLanguageListTypeConverter

@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    CollectionInfoTypeConverter::class,
    GenreListTypeConverter::class,
    ProductionCompanyListTypeConverter::class,
    ProductionCountryListTypeConverter::class,
    SpokenLanguageListTypeConverter::class,
    OriginCountryTypeConverter::class
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun movieDao() : MovieDao
}