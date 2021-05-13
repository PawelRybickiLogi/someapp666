package com.company.moviesList

import androidx.lifecycle.viewModelScope
import com.company.coreArchitecture.BaseViewModel
import com.company.movies.networking.IMoviesRepository
import kotlinx.coroutines.launch

class MoviesListViewModel(
    private val moviesRepository: IMoviesRepository
) : BaseViewModel<MoviesListUiModel>() {

    init {
        uiState = MoviesListUiModel(state = MoviesListState.Empty)
    }

    fun fetchMovies(query: String) {
        viewModelScope.launch {
            try {
                uiState = MoviesListUiModel(state = MoviesListState.Loading)
                val movies = moviesRepository.getMovies(query)
                uiState = MoviesListUiModel(state = MoviesListState.Success(movies))
            } catch (e: Exception) {
                uiState = MoviesListUiModel(state = MoviesListState.Empty)
            }
        }
    }
}