package com.company.movies.networking.dto

import com.squareup.moshi.Json

internal data class MovieDto(
    @Json(name = "Title") val title: String,
    @Json(name = "Year") val year: String,
    @Json(name = "imdbID") val id: String,
    @Json(name = "Type") val type: String,
    @Json(name = "Poster") val poster: String
)

data class Movie(
    val id: String,
    val title: String,
    val image: String
)