package com.zg.netflixloginscreenjetpackcompose.network.responses

import com.zg.netflixloginscreenjetpackcompose.data.models.Actor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreditResponse (
    @SerialName("id")
    val id : Int,
    @SerialName("cast")
    val cast: List<Actor>,
    @SerialName("crew")
    val crew : List<Actor>
)