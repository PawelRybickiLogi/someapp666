package com.company.movieDetails


import com.company.coreArchitecture.UiModel
import com.company.movies.networking.dto.MovieDetail

sealed class MoviesDetailsState {
    object Loading : MoviesDetailsState()
    object Error: MoviesDetailsState()
    data class Success(val movie: MovieDetail) : MoviesDetailsState()
}

data class MovieDetailsUiModel(
    val state: MoviesDetailsState
) : UiModel() {

    override fun update(newModel: UiModel) =
        (newModel as MovieDetailsUiModel).copy(
            state = newModel.state
        )
}