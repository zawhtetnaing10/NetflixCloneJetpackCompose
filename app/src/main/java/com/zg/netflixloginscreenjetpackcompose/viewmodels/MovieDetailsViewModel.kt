package com.zg.netflixloginscreenjetpackcompose.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.zg.netflixloginscreenjetpackcompose.data.repository.MovieDataRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel(assistedFactory = MovieDetailsViewModel.MovieDetailsViewModelFactory::class)
class MovieDetailsViewModel @AssistedInject constructor(
    @Assisted movieId : Int,
    val movieDataRepository: MovieDataRepository,
) : ViewModel() {

    init {
        Log.d("MovieId", movieId.toString())
    }

    @AssistedFactory
    interface MovieDetailsViewModelFactory {
        fun create (movieId : Int) : MovieDetailsViewModel
    }
}