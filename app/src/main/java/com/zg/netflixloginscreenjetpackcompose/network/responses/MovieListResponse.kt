package com.zg.netflixloginscreenjetpackcompose.network.responses

import com.zg.netflixloginscreenjetpackcompose.data.models.DateRange
import com.zg.netflixloginscreenjetpackcompose.data.models.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieListResponse (
    @SerialName("dates")
    val date : DateRange?,

    @SerialName("page")
    val page : Int,

    @SerialName("results")
    val movieList: List<Movie>?
)