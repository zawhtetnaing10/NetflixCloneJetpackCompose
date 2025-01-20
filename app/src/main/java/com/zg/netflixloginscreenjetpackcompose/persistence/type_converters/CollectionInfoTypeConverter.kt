package com.zg.netflixloginscreenjetpackcompose.persistence.type_converters

import androidx.room.TypeConverter
import com.zg.netflixloginscreenjetpackcompose.data.models.CollectionInfo
import com.zg.netflixloginscreenjetpackcompose.utils.universalJsonConverter
import kotlinx.serialization.encodeToString

class CollectionInfoTypeConverter {
    @TypeConverter
    fun fromCollectionInfo(collectionInfo: CollectionInfo?): String? {
        return collectionInfo?.let { universalJsonConverter.encodeToString(it) }
    }

    @TypeConverter
    fun toCollectionInfo(json: String?): CollectionInfo? {
        return json?.let { universalJsonConverter.decodeFromString(json) }
    }
}