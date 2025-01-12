package com.zg.netflixloginscreenjetpackcompose.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zg.netflixloginscreenjetpackcompose.data.repository.MovieDataRepository
import com.zg.netflixloginscreenjetpackcompose.states.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieDataRepository: MovieDataRepository
) : ViewModel() {

    // State
    private val _homeScreenState = MutableStateFlow(HomeScreenState())
    val homeScreenState: StateFlow<HomeScreenState> get() = _homeScreenState

    init {
        viewModelScope.launch {
            // Fetch NowPlaying movies
            movieDataRepository.getFeaturedMovie()
                .catch { throwable ->
                    // TODO: - Show error dialog here.
                    Log.d("NPMoviesError", throwable.toString())
                }
                .collect{
                    Log.d("NPMoviesVM", it.toString())
                    _homeScreenState.value = homeScreenState.value.copy(
                        featuredMovie = it
                    )
                }
        }
    }
}