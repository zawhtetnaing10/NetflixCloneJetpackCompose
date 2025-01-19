package com.zg.netflixloginscreenjetpackcompose.network

// Base Url
const val BASE_URL = "https://api.themoviedb.org/3/"

// Endpoints
const val ENDPOINT_NOW_PLAYING = "movie/now_playing"
const val ENDPOINT_COMING_SOON = "movie/upcoming"
const val ENDPOINT_MOVIE_DETAILS = "movie"
const val ENDPOINT_CREDITS = "movie"
const val ENDPOINT_GENRES = "genre/movie/list"
const val ENDPOINT_MOVIES_BY_GENRE = "discover/movie"
const val ENDPOINT_GET_VIDEOS = "movie"

// Headers
const val HEADER_AUTHORIZATION = "Authorization"

// Params
const val PARAM_LANGUAGE = "language"
const val PARAM_PAGE = "page"
const val PARAM_WITH_GENRES = "with_genres"


// Default Params
const val DEFAULT_PARAM_EN_US = "en-US"