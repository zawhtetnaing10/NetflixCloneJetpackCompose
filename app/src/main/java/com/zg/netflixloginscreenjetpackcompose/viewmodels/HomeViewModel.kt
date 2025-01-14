package com.zg.netflixloginscreenjetpackcompose.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zg.netflixloginscreenjetpackcompose.data.models.Movie
import com.zg.netflixloginscreenjetpackcompose.data.repository.MovieDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
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
            fetchFeaturedMovie()
        }
    }

    /**
     * Fetches featured movie from repository
     */
    private suspend fun fetchFeaturedMovie() {
        movieDataRepository.getFeaturedMovie()
            .onStart {
                _homeScreenState.value = _homeScreenState.value.copy(isLoading = true)
            }
            .catch { throwable ->
                _homeScreenState.value = _homeScreenState.value.copy(errorMessage = throwable.message ?: "")
            }
            .collect {
                _homeScreenState.value = homeScreenState.value.copy(featuredMovie = it)
            }
    }
}

/**
 * State of the Home Screen
 */
data class HomeScreenState(
    val featuredMovie: Movie? = null,
    val isLoading: Boolean = false,
    val errorMessage: String = "",
)