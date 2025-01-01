package com.zg.netflixloginscreenjetpackcompose.viewmodels

import androidx.lifecycle.ViewModel
import com.zg.netflixloginscreenjetpackcompose.data.repository.MovieDataRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    val movieDataRepository: MovieDataRepository
) : ViewModel()