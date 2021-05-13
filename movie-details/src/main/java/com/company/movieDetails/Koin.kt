package com.company.movieDetails

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieDetailsModule = module {
    viewModel { MovieDetailsViewModel(get()) }
}