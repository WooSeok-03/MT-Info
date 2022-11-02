package com.android.mtinfo.domain.repository

import com.android.mtinfo.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
}