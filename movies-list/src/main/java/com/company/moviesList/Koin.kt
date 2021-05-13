package com.company.moviesList

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moviesListModule = module {
    viewModel { MoviesListViewModel(get()) }
}