package com.zg.netflixloginscreenjetpackcompose.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrailerVideo(
    @SerialName("iso_639_1")
    val iso6391: String,
    @SerialName("iso_3166_1")
    val iso31661: String,
    @SerialName("name")
    val name: String,
    @SerialName("key")
    val key: String,
    @SerialName("site")
    val site: String,
    @SerialName("size")
    val size: Int,
    @SerialName("type")
    val type: String,
    @SerialName("official")
    val official: Boolean,
    @SerialName("published_at")
    val publishedAt: String,
    @SerialName("id")
    val id: String
) {
    /**
     * Checks if the video is Youtube.
     */
    fun isYoutubeVideo() : Boolean {
        return site == YOUTUBE_VIDEO
    }
}

// Youtube video type
const val YOUTUBE_VIDEO = "YouTube"
