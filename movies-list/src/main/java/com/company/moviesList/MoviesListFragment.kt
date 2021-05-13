package com.company.moviesList

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.company.coreArchitecture.BaseFragment
import com.company.movies.Arguments
import com.company.utils.extensions.observeTextChanges
import com.company.utils.extensions.onClick
import com.company.utils.extensions.visibleIf
import kotlinx.android.synthetic.main.fragment_movies_list.*
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesListFragment : BaseFragment<MoviesListUiModel, MoviesListViewModel>(R.layout.fragment_movies_list) {

    override val viewModel: MoviesListViewModel by viewModel()

    override fun initViews(view: View) {
        viewLifecycleOwner.lifecycleScope.launch {
            moviesListSearch.observeTextChanges()
                .debounce(1000)
                .distinctUntilChanged()
                .onEach { viewModel.fetchMovies(it) }
                .launchIn(this)
        }

        moviesListItems.run {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = MoviesListAdapter(onMovieSelected = {
                findNavController().navigate(R.id.navigate_movies_list_to_detail, bundleOf(
                    Arguments.MOVIE_DETAIL_ID to it.id
                ))
            })
        }
    }

    override fun render(model: MoviesListUiModel) {
        model.run {
            moviesListLoading.visibleIf(state is MoviesListState.Loading)
            moviesListSearchHint.visibleIf(state is MoviesListState.Empty)
            moviesListItems.visibleIf(state is MoviesListState.Success)

            when(state) {
                is MoviesListState.Success -> {
                    (moviesListItems.adapter as MoviesListAdapter).setTeams(state.movies)
                }
                else -> { /* some optional additional logic for other states */ }
            }
        }
    }
}