package com.company.movieDetails

import androidx.lifecycle.viewModelScope
import com.company.coreArchitecture.BaseViewModel
import com.company.movies.networking.IMoviesRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

class MovieDetailsViewModel(
    private val moviesRepository: IMoviesRepository
) : BaseViewModel<MovieDetailsUiModel>() {

    fun loadMovieDetails(movieId: String) {
        viewModelScope.launch {
            try {
                uiState = MovieDetailsUiModel(state = MoviesDetailsState.Loading)
                val movieDetails = moviesRepository.getMovieDetail(movieId)
                uiState = MovieDetailsUiModel(state = MoviesDetailsState.Success(movieDetails))
            } catch (e: Exception) {
                uiState = MovieDetailsUiModel(state = MoviesDetailsState.Error)
            }
        }
    }
}