package com.zg.netflixloginscreenjetpackcompose.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zg.netflixloginscreenjetpackcompose.data.models.CastAndCrew
import com.zg.netflixloginscreenjetpackcompose.data.models.Genre
import com.zg.netflixloginscreenjetpackcompose.data.models.Movie
import com.zg.netflixloginscreenjetpackcompose.data.models.TrailerVideo
import com.zg.netflixloginscreenjetpackcompose.data.repository.MovieDataRepository
import com.zg.netflixloginscreenjetpackcompose.utils.RELATED_MOVIE_COUNT
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

/**
 * View Model for Movie Details Screen
 */
@HiltViewModel(assistedFactory = MovieDetailsViewModel.MovieDetailsViewModelFactory::class)
class MovieDetailsViewModel @AssistedInject constructor(
    @Assisted movieId: Int,
    private val movieDataRepository: MovieDataRepository,
) : ViewModel() {

    @AssistedFactory
    interface MovieDetailsViewModelFactory {
        fun create(movieId: Int): MovieDetailsViewModel
    }

    // State
    private val _detailsScreenState = MutableStateFlow(MovieDetailsScreenState())
    val detailsScreenState: StateFlow<MovieDetailsScreenState> get() = _detailsScreenState

    init {
        viewModelScope.launch {
            launch { fetchMovieDetails(movieId = movieId) }
            launch { fetchCreditsByMovie(movieId = movieId) }
            launch { fetchTrailer(movieId = movieId) }
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

                // Fetch Related Movies
                fetchRelatedMovies(it?.genres ?: listOf())
            }
    }

    /**
     * Fetch Credits for Movie
     */
    private suspend fun fetchCreditsByMovie(movieId: Int) {
        movieDataRepository.fetchCreditsByMovie(movieId = movieId)
            .catch {
                _detailsScreenState.value = _detailsScreenState.value.copy(errorMessage = it.message ?: "")
            }
            .collect {
                _detailsScreenState.value = _detailsScreenState.value.copy(
                    cast = it.cast,
                    crew = it.crew
                )
            }
    }

    /**
     * Fetches trailer for movie
     */
    private suspend fun fetchTrailer(movieId: Int) {
        movieDataRepository.fetchTrailerForMovie(movieId = movieId)
            .catch {
                _detailsScreenState.value = _detailsScreenState.value.copy(errorMessage = it.message ?: "")
            }
            .collect {
                _detailsScreenState.value = _detailsScreenState.value.copy(
                    trailer = it
                )
            }
    }

    /**
     * Related movies
     */
    private suspend fun fetchRelatedMovies(genres: List<Genre>) {
        try {
            // Fetch related movies and remove duplicates and take a set amount of related movies
            val relatedMovies = movieDataRepository.fetchMoviesByGenreList(genreList = genres)
                .toList()
                .flatten()
                .distinctBy { it.id }
            // Remove the current movie
            val relatedMoviesToShow = relatedMovies.toMutableList()
            relatedMoviesToShow.removeIf { it.id ==  _detailsScreenState.value.movie?.id}

            _detailsScreenState.value = _detailsScreenState.value.copy(relatedMovies = relatedMoviesToShow.take(RELATED_MOVIE_COUNT))
        } catch (e: Exception) {
            _detailsScreenState.value = _detailsScreenState.value.copy(errorMessage = e.message ?: "")
        }
    }
}

data class MovieDetailsScreenState(
    val movie: Movie? = null,
    val errorMessage: String = "",
    val isLoading: Boolean = false,
    val cast: List<CastAndCrew>? = null,
    val crew: List<CastAndCrew>? = null,
    val trailer: TrailerVideo? = null,
    val relatedMovies: List<Movie>? = null,
)