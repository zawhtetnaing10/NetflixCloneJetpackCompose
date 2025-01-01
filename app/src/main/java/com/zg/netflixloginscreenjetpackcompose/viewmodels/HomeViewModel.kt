package com.zg.netflixloginscreenjetpackcompose.viewmodels

import androidx.lifecycle.ViewModel
import com.zg.netflixloginscreenjetpackcompose.data.repository.MovieDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieDataRepository: MovieDataRepository
) : ViewModel() {
    init {
        // TODO: - Fetch NowPlaying movies
    }
}