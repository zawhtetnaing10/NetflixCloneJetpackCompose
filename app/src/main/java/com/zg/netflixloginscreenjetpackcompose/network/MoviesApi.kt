package com.zg.netflixloginscreenjetpackcompose.network

import com.zg.netflixloginscreenjetpackcompose.network.Responses.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MoviesApi {
    @GET(ENDPOINT_NOW_PLAYING)
    suspend fun getNowPlayingMovies(
        @Header(HEADER_AUTHORIZATION) authorization: String,
        @Query(PARAM_PAGE) page: String,
        @Query(PARAM_LANGUAGE) language: String = DEFAULT_PARAM_EN_US
    ) : MovieListResponse
}