package com.zg.netflixloginscreenjetpackcompose.persistence.type_converters

import androidx.room.TypeConverter
import com.zg.netflixloginscreenjetpackcompose.data.models.SpokenLanguage
import com.zg.netflixloginscreenjetpackcompose.utils.universalJsonConverter
import kotlinx.serialization.encodeToString

class SpokenLanguageListTypeConverter {
    @TypeConverter
    fun fromSpokenLanguages(spokenLanguages : List<SpokenLanguage>?) : String? {
        return spokenLanguages?.let { universalJsonConverter.encodeToString(it) }
    }

    @TypeConverter
    fun toSpokenLanguages(json : String?) : List<SpokenLanguage>? {
        return json?.let { universalJsonConverter.decodeFromString(it) }
    }
}