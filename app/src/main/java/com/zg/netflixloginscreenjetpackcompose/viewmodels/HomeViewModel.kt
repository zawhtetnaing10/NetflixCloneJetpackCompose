package com.zg.netflixloginscreenjetpackcompose.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zg.netflixloginscreenjetpackcompose.data.models.Movie
import com.zg.netflixloginscreenjetpackcompose.data.repository.MovieDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.toList
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
            launch { fetchFeaturedMovie() }
            launch { fetchMoviesByGenre() }
        }
    }

    /**
     * Fetches Movies By Genre From Repository
     */
    private suspend fun fetchMoviesByGenre() {
        try {
            val movieByGenreList = movieDataRepository.fetchMoviesByGenre().toList()
            _homeScreenState.value = _homeScreenState.value.copy(
                moviesWithGenre = movieByGenreList, isLoading = false
            )
        } catch (e: Exception) {
            _homeScreenState.value = homeScreenState.value.copy(errorMessage = e.message ?: "", isLoading = false)
        }
    }

    /**
     * Fetches featured movie from repository
     */
    private suspend fun fetchFeaturedMovie() {
        movieDataRepository.fetchFeaturedMovie()
            .catch { throwable ->
                _homeScreenState.value = _homeScreenState.value.copy(errorMessage = throwable.message ?: "", isLoading = false)
            }
            .collect {
                _homeScreenState.value = homeScreenState.value.copy(featuredMovie = it, isLoading = false)
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
    val mobileGames: List<String>? = null,
    val continueWatching: List<Movie>? = null,
    val moviesWithGenre: List<Pair<String, List<Movie>>>? = null
)