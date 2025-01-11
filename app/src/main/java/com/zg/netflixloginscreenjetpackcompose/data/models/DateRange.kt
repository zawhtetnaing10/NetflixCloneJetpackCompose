package com.zg.netflixloginscreenjetpackcompose.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DateRange(
    @SerialName("maximum")
    val maximum: String,

    @SerialName("minimum")
    val minimum: String,
)