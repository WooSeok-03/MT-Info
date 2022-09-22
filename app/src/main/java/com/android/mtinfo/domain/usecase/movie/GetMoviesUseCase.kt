package com.android.mtinfo.domain.usecase.movie

import com.android.mtinfo.data.model.movie.Movie
import com.android.mtinfo.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}