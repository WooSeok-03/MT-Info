package com.android.mtinfo.data.repository.movie

import com.android.mtinfo.data.model.movie.Movie
import com.android.mtinfo.domain.repository.MovieRepository

class MovieRepositoryImpl(
    // UseCase
): MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateMovies(): List<Movie>? {
        TODO("Not yet implemented")
    }

    override suspend fun saveMovies() {
        TODO("Not yet implemented")
    }

}