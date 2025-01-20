package com.zg.netflixloginscreenjetpackcompose.persistence.type_converters

import androidx.room.TypeConverter
import com.zg.netflixloginscreenjetpackcompose.utils.universalJsonConverter
import kotlinx.serialization.encodeToString

class OriginCountryTypeConverter {
    @TypeConverter
    fun fromOriginCountries(originCountries : List<String>?) : String? {
        return originCountries?.let { universalJsonConverter.encodeToString(it) }
    }

    @TypeConverter
    fun toOriginCountries(json : String?) : List<String>? {
        return json?.let { universalJsonConverter.decodeFromString(it) }
    }
}