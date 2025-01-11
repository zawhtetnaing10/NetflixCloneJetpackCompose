package com.zg.netflixloginscreenjetpackcompose.states

import com.zg.netflixloginscreenjetpackcompose.data.models.Movie

/**
 * State of the Home Screen
 */
data class HomeScreenState(
    val nowPlayingMovies : List<Movie>? = null,
)