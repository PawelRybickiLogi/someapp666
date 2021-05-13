package com.company.movies.networking.dto

import com.squareup.moshi.Json

internal data class MoviesListDto(
    val totalResults: Int,
    @Json(name = "Search") val Search: List<MovieDto>
)