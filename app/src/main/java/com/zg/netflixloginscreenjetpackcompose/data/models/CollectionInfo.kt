package com.zg.netflixloginscreenjetpackcompose.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollectionInfo(
    @SerialName("id")
    val id: Int?,

    @SerialName("name")
    val name: String?,

    @SerialName("poster_path")
    val posterPath: String?,

    @SerialName("backdrop_path")
    val backdropPath: String?
)