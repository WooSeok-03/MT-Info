package com.android.mtinfo.data.repository.movie.datasourceImpl

import com.android.mtinfo.data.api.TMDBService
import com.android.mtinfo.data.model.movie.MovieList
import com.android.mtinfo.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService
): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies()
}