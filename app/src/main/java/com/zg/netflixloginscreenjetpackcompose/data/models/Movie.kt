package com.zg.netflixloginscreenjetpackcompose.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zg.netflixloginscreenjetpackcompose.utils.FEATURED_MOVIE_IMAGE_BASE_URL
import com.zg.netflixloginscreenjetpackcompose.utils.GENERAL_MOVIE_IMAGE_BASE_URL
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Entity(tableName = "movies")
@Serializable
data class Movie(
    @SerialName("adult")
    @ColumnInfo("adult")
    val adult: Boolean?,

    @SerialName("backdrop_path")
    @ColumnInfo("backdrop_path")
    val backdropPath: String? = null,

    @SerialName("belongs_to_collection")
    @ColumnInfo("belongs_to_collection")
    val belongsToCollection: CollectionInfo? = null,

    @SerialName("budget")
    @ColumnInfo("budget")
    val budget: Int?,

    @SerialName("genres")
    @ColumnInfo("genres")
    val genres: List<Genre>?,

    @SerialName("homepage")
    @ColumnInfo("homepage")
    val homepage: String?,

    @SerialName("id")
    @ColumnInfo("id")
    @PrimaryKey
    val id: Int?,

    @SerialName("imdb_id")
    @ColumnInfo("imdb_id")
    val imdbId: String?,

    @SerialName("origin_country")
    @ColumnInfo("origin_country")
    val originCountry: List<String>?,

    @SerialName("original_language")
    @ColumnInfo("original_language")
    val originalLanguage: String?,

    @SerialName("original_title")
    @ColumnInfo("original_title")
    val originalTitle: String?,

    @SerialName("overview")
    @ColumnInfo("overview")
    val overview: String?,

    @SerialName("popularity")
    @ColumnInfo("popularity")
    val popularity: Double?,

    @SerialName("poster_path")
    @ColumnInfo("poster_path")
    val posterPath: String?,

    @SerialName("production_companies")
    @ColumnInfo("production_companies")
    val productionCompanies: List<ProductionCompany>?,

    @SerialName("production_countries")
    @ColumnInfo("production_countries")
    val productionCountries: List<ProductionCountry>?,

    @SerialName("release_date")
    @ColumnInfo("release_date")
    val releaseDate: String?,

    @SerialName("revenue")
    @ColumnInfo("revenue")
    val revenue: Int?,

    @SerialName("runtime")
    @ColumnInfo("runtime")
    val runtime: Int?,

    @SerialName("spoken_languages")
    @ColumnInfo("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>?,

    @SerialName("status")
    @ColumnInfo("status")
    val status: String?,

    @SerialName("tagline")
    @ColumnInfo("tagline")
    val tagline: String?,

    @SerialName("title")
    @ColumnInfo("title")
    val title: String?,

    @SerialName("video")
    @ColumnInfo("video")
    val video: Boolean?,

    @SerialName("vote_average")
    @ColumnInfo("vote_average")
    val voteAverage: Double?,

    @SerialName("vote_count")
    @ColumnInfo("vote_count")
    val voteCount: Int?,

    @Transient
    var continueWatching: Int? = 0
) {

    /**
     * Gets the back drop image path for featured movie
     * This will be in 1200 px width
     */
    fun getFullFeaturedMovieImagePath(): String {
        return "$FEATURED_MOVIE_IMAGE_BASE_URL$backdropPath"
    }

    /**
     * Gets the poster image path for featured movie
     * This will be in 400 px width
     */
    fun getFullPosterPath(): String {
        return "$GENERAL_MOVIE_IMAGE_BASE_URL$posterPath"
    }

    /**
     * Returns the release year of the function
     */
    fun getReleaseYear(): String {
        return releaseDate?.split("-")?.first() ?: ""
    }

    /**
     * Get run time in 1h 59m format
     */
    fun getRuntimeFormatted(): String {
        if(runtime == null) return ""
        val hours = runtime / 60
        val minutes = runtime % 60
        return "${hours}h ${minutes}m"
    }

    /**
     * Checks if the movie is recently released
     * The movie is recently released if the current date falls within one week of release date
     */
    fun isRecentlyReleased(): Boolean {
        // Guard
        if(releaseDate.isNullOrEmpty()) return false

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val givenDate = dateFormat.parse(releaseDate) ?: return false
        val currentDate = Calendar.getInstance()
        val oneWeekBefore = Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, -7) }
        return givenDate.after(oneWeekBefore.time) && givenDate.before(currentDate.time)
    }
}