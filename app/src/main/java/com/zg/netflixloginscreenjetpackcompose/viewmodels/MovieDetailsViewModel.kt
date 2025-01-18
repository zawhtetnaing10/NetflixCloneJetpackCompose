package com.zg.netflixloginscreenjetpackcompose.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zg.netflixloginscreenjetpackcompose.data.models.Movie
import com.zg.netflixloginscreenjetpackcompose.data.repository.MovieDataRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

/**
 * View Model for Movie Details Screen
 */
@HiltViewModel(assistedFactory = MovieDetailsViewModel.MovieDetailsViewModelFactory::class)
class MovieDetailsViewModel @AssistedInject constructor(
    @Assisted movieId: Int,
    private val movieDataRepository: MovieDataRepository,
) : ViewModel() {

    // State
    private val _detailsScreenState = MutableStateFlow(MovieDetailsScreenState())
    val detailsScreenState: StateFlow<MovieDetailsScreenState> get() = _detailsScreenState

    init {
        viewModelScope.launch {
            launch { fetchMovieDetails(movieId = movieId) }
        }
    }

    /**
     * Fetch Movie Details From Repository
     */
    private suspend fun fetchMovieDetails(movieId: Int) {
        movieDataRepository.fetchMovieDetails(movieId)
            .catch {
                _detailsScreenState.value = _detailsScreenState.value.copy(errorMessage = it.message ?: "")
            }
            .collect {
                _detailsScreenState.value = _detailsScreenState.value.copy(movie = it)
            }
    }

    @AssistedFactory
    interface MovieDetailsViewModelFactory {
        fun create(movieId: Int): MovieDetailsViewModel
    }
}

data class MovieDetailsScreenState(
    val movie: Movie? = null,
    val errorMessage: String = "",
    val isLoading: Boolean = false
)