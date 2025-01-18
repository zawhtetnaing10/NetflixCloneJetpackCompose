package com.zg.netflixloginscreenjetpackcompose.network.responses

import com.zg.netflixloginscreenjetpackcompose.data.models.Genre
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenreListResponse(
    @SerialName("genres")
    val genres : List<Genre>
)