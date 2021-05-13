package com.company.movies.networking.dto

import com.squareup.moshi.Json

internal data class MovieDetailsDto(
    @Json(name = "Title") val title: String,
    @Json(name = "Year") val year: String,
    @Json(name = "Rated") val rated: String,
    @Json(name = "Released") val released: String,
    @Json(name = "Runtime") val runtime: String,
    @Json(name = "Genre") val genre: String,
    @Json(name = "Director") val director: String,
    @Json(name = "Writer") val writer: String,
    @Json(name = "Actors") val actors: String,
    @Json(name = "Plot") val plot: String,
    @Json(name = "Language") val language: String,
    @Json(name = "Country") val country: String,
    @Json(name = "Awards") val awards: String,
    @Json(name = "Poster") val poster: String,
    @Json(name = "Metascore") val metascore: String,
    val imdbRating: String,
    val imdbVotes: String
)

data class MovieDetail(
    val title: String,
    val description: String,
    val year: String,
    val image: String,
    val score: String,
    val rating: String,
    val votes: String,
    val director: String,
    val writer: String,
    val actors: String
)