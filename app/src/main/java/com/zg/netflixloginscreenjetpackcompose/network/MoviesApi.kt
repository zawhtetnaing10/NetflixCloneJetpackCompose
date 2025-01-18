package com.zg.netflixloginscreenjetpackcompose.network

import com.zg.netflixloginscreenjetpackcompose.data.models.Movie
import com.zg.netflixloginscreenjetpackcompose.network.responses.GenreListResponse
import com.zg.netflixloginscreenjetpackcompose.network.responses.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {
    @GET(ENDPOINT_NOW_PLAYING)
    suspend fun getNowPlayingMovies(
        @Header(HEADER_AUTHORIZATION) authorization: String,
        @Query(PARAM_PAGE) page: String,
        @Query(PARAM_LANGUAGE) language: String = DEFAULT_PARAM_EN_US
    ): MovieListResponse

    @GET("$ENDPOINT_MOVIE_DETAILS/{movie_id}")
    suspend fun getMovieDetails(
        @Header(HEADER_AUTHORIZATION) authorization: String,
        @Path("movie_id") movieId: Int,
    ): Movie

    @GET(ENDPOINT_GENRES)
    suspend fun getGenres(
        @Header(HEADER_AUTHORIZATION) authorization: String,
    ): GenreListResponse


    @GET(ENDPOINT_MOVIES_BY_GENRE)
    suspend fun getMoviesByGenre(
        @Header(HEADER_AUTHORIZATION) authorization: String,
        @Query(PARAM_WITH_GENRES) genreId: Int,
    ) : MovieListResponse
}