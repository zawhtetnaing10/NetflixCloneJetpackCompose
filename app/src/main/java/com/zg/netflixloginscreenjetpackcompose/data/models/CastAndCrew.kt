package com.zg.netflixloginscreenjetpackcompose.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CastAndCrew(
    @SerialName("adult")
    val adult: Boolean,
    @SerialName("gender")
    val gender: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("known_for_department")
    val knownForDepartment: String,
    @SerialName("name")
    val name: String,
    @SerialName("original_name")
    val originalName: String,
    @SerialName("popularity")
    val popularity: Double,
    @SerialName("profile_path")
    val profilePath: String?,
    @SerialName("cast_id")
    val castId: Int?,
    @SerialName("character")
    val character: String?,
    @SerialName("credit_id")
    val creditId: String,
    @SerialName("order")
    val order: Int?,
    @SerialName("job")
    val job: String?
) {
    /**
     * Checks if current actor is director
     */
    fun isDirector() : Boolean {
        return job == JOB_DIRECTOR
    }
}

const val JOB_DIRECTOR = "Director"