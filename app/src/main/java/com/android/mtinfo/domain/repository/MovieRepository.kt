package com.android.mtinfo.domain.repository

import com.android.mtinfo.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun saveMovie(movie: Movie)
    suspend fun deleteMovie(movie: Movie)
}