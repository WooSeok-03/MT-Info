package com.android.mtinfo.data.repository.datasource

import com.android.mtinfo.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}