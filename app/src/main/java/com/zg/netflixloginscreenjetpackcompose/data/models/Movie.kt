package com.zg.netflixloginscreenjetpackcompose.data.models

import com.zg.netflixloginscreenjetpackcompose.utils.FEATURED_MOVIE_IMAGE_BASE_URL
import com.zg.netflixloginscreenjetpackcompose.utils.GENERAL_MOVIE_IMAGE_BASE_URL
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    @SerialName("adult")
    val adult: Boolean?,

    @SerialName("backdrop_path")
    val backdropPath: String? = null,

    @SerialName("belongs_to_collection")
    val belongsToCollection: CollectionInfo? = null,

    @SerialName("budget")
    val budget: Int?,

    @SerialName("genres")
    val genres: List<Genre>?,

    @SerialName("homepage")
    val homepage: String?,

    @SerialName("id")
    val id: Int?,

    @SerialName("imdb_id")
    val imdbId: String?,

    @SerialName("origin_country")
    val originCountry: List<String>?,

    @SerialName("original_language")
    val originalLanguage: String?,

    @SerialName("original_title")
    val originalTitle: String?,

    @SerialName("overview")
    val overview: String?,

    @SerialName("popularity")
    val popularity: Double?,

    @SerialName("poster_path")
    val posterPath: String?,

    @SerialName("production_companies")
    val productionCompanies: List<ProductionCompany>?,

    @SerialName("production_countries")
    val productionCountries: List<ProductionCountry>?,

    @SerialName("release_date")
    val releaseDate: String?,

    @SerialName("revenue")
    val revenue: Int?,

    @SerialName("runtime")
    val runtime: Int?,

    @SerialName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>?,

    @SerialName("status")
    val status: String?,

    @SerialName("tagline")
    val tagline: String?,

    @SerialName("title")
    val title: String?,

    @SerialName("video")
    val video: Boolean?,

    @SerialName("vote_average")
    val voteAverage: Double?,

    @SerialName("vote_count")
    val voteCount: Int?
) {

    /**
     * Gets the back drop image path for featured movie
     * This will be in 1200 px width
     */
    fun getFullFeaturedMovieImagePath() : String {
        return "$FEATURED_MOVIE_IMAGE_BASE_URL$backdropPath"
    }

    /**
     * Gets the poster image path for featured movie
     * This will be in 400 px width
     */
    fun getFullPosterPath() : String{
        return "$GENERAL_MOVIE_IMAGE_BASE_URL$posterPath"
    }
}