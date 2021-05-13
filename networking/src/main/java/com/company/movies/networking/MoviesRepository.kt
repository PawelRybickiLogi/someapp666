package com.company.movies.networking

import com.company.movies.networking.dto.Movie
import com.company.movies.networking.dto.MovieDetail

interface IMoviesRepository {
    suspend fun getMovies(query: String): List<Movie>
    suspend fun getMovieDetail(id: String): MovieDetail
}

internal class MoviesRepository(
    private val api: MoviesApi
) : IMoviesRepository {

    override suspend fun getMovies(query: String) = api.getMovies(query).Search.map {
        Movie(
            id = it.id,
            title = it.title,
            image = it.poster
        )
    }

    override suspend fun getMovieDetail(id: String) = with(api.getMovieDetails(id)) {
        MovieDetail(
            title = title,
            description = plot,
            year = year,
            image = poster,
            score = metascore,
            rating = imdbRating,
            votes = imdbVotes,
            director = director,
            writer = writer,
            actors = actors
        )
    }
}