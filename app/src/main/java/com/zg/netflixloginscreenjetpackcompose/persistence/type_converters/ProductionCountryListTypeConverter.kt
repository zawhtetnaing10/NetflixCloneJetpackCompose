package com.zg.netflixloginscreenjetpackcompose.persistence.type_converters

import androidx.room.TypeConverter
import com.zg.netflixloginscreenjetpackcompose.data.models.ProductionCountry
import com.zg.netflixloginscreenjetpackcompose.utils.universalJsonConverter
import kotlinx.serialization.encodeToString

class ProductionCountryListTypeConverter {
    @TypeConverter
    fun fromProductionCountries(productionCountries: List<ProductionCountry>?): String? {
        return productionCountries?.let { universalJsonConverter.encodeToString(it) }
    }

    @TypeConverter
    fun toProductionCountries(json: String?) : List<ProductionCountry>? {
        return json?.let { universalJsonConverter.decodeFromString(it) }
    }
}