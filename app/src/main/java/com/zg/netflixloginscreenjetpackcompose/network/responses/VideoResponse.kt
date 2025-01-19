package com.zg.netflixloginscreenjetpackcompose.network.responses

import com.zg.netflixloginscreenjetpackcompose.data.models.TrailerVideo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("results")
    val results: List<TrailerVideo>
)