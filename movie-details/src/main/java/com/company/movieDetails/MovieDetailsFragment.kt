package com.company.movieDetails

import android.view.View
import coil.load
import com.company.coreArchitecture.BaseFragment
import com.company.movies.Arguments
import com.company.utils.extensions.onClick
import com.company.utils.extensions.visibleIf
import kotlinx.android.synthetic.main.fragment_movie_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsFragment : BaseFragment<MovieDetailsUiModel, MovieDetailsViewModel>(R.layout.fragment_movie_details) {

    override val viewModel : MovieDetailsViewModel by viewModel()

    private val movieId by lazy { (requireArguments().getString(Arguments.MOVIE_DETAIL_ID) as String) }

    override fun initViews(view: View) {
        viewModel.loadMovieDetails(movieId)
        movieDetailError.onClick { viewModel.loadMovieDetails(movieId) }
    }

    override fun render(model: MovieDetailsUiModel) {
        movieDetailLoading.visibleIf(model.state is MoviesDetailsState.Loading)
        movieDetailContent.visibleIf(model.state is MoviesDetailsState.Success)
        movieDetailError.visibleIf(model.state is MoviesDetailsState.Error)

        model.run {
            when(state) {
                is MoviesDetailsState.Success -> {
                    with(state.movie) {
                        movieDetailImage.load(image)
                        movieDetailTitle.text = title
                        movieDetailYear.text = year
                        movieDetailDescription.text = description
                        movieDetailScore.text = score
                        movieDetailRating.text = rating
                        movieDetailPopularity.text = votes
                        movieDetailDirector.text = director
                        movieDetailWriter.text = writer
                        movieDetailActors.text = actors
                    }
                }
                else -> { }
            }
        }
    }
}