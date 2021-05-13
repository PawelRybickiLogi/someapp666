package com.company.moviesList

import com.company.coreArchitecture.UiModel
import com.company.movies.networking.dto.Movie

sealed class MoviesListState {
    object Loading : MoviesListState()
    object Empty: MoviesListState()
    data class Success(val movies: List<Movie>) : MoviesListState()
}

data class MoviesListUiModel(
    val state: MoviesListState
) : UiModel() {

    override fun update(newModel: UiModel) =
        (newModel as MoviesListUiModel).copy(
            state = newModel.state
        )
}