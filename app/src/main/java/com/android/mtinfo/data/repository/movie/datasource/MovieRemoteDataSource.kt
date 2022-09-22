package com.android.mtinfo.data.repository.movie.datasource

import com.android.mtinfo.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}