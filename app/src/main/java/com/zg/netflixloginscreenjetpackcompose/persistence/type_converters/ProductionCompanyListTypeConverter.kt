package com.zg.netflixloginscreenjetpackcompose.persistence.type_converters

import androidx.room.TypeConverter
import com.zg.netflixloginscreenjetpackcompose.data.models.ProductionCompany
import com.zg.netflixloginscreenjetpackcompose.utils.universalJsonConverter
import kotlinx.serialization.encodeToString

class ProductionCompanyListTypeConverter {
    @TypeConverter
    fun fromProductionCompanyList(productionCompanies : List<ProductionCompany>?) : String? {
        return productionCompanies?.let { universalJsonConverter.encodeToString(it) }
    }

    @TypeConverter
    fun toProductionCompanyList(json : String?) : List<ProductionCompany>? {
        return json?.let { universalJsonConverter.decodeFromString(it) }
    }
}