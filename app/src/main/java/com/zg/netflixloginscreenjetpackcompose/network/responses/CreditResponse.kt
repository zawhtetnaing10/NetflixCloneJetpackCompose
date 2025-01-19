package com.zg.netflixloginscreenjetpackcompose.network.responses

import com.zg.netflixloginscreenjetpackcompose.data.models.CastAndCrew
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreditResponse (
    @SerialName("id")
    val id : Int,
    @SerialName("cast")
    val cast: List<CastAndCrew>,
    @SerialName("crew")
    val crew : List<CastAndCrew>
)