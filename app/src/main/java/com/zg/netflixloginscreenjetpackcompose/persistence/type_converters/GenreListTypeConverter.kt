package com.zg.netflixloginscreenjetpackcompose.persistence.type_converters

import androidx.room.TypeConverter
import com.zg.netflixloginscreenjetpackcompose.data.models.Genre
import com.zg.netflixloginscreenjetpackcompose.utils.universalJsonConverter
import kotlinx.serialization.encodeToString

class GenreListTypeConverter {
    @TypeConverter
    fun fromGenres(genres: List<Genre>?): String? {
        return genres?.let { universalJsonConverter.encodeToString(it) }
    }

    @TypeConverter
    fun toGenres(json: String?): List<Genre>? {
        return json?.let { universalJsonConverter.decodeFromString(json) }
    }
}