package com.company.movies.networking

import com.company.movies.networking.dto.MovieDetailsDto
import com.company.movies.networking.dto.MoviesListDto
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MoviesApi {

    @GET("?apiKey=${Configuration.API_KEY}&?type=movie")
    suspend fun getMovies(
            @Query("s") query: String
    ): MoviesListDto

    @GET("?apiKey=${Configuration.API_KEY}")
    suspend fun getMovieDetails(
            @Query("i") id: String
    ): MovieDetailsDto
}