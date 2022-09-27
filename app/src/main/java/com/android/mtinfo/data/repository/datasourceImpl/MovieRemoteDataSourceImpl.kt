package com.android.mtinfo.data.repository.datasourceImpl

import com.android.mtinfo.data.api.TMDBService
import com.android.mtinfo.data.model.movie.MovieList
import com.android.mtinfo.data.repository.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService
): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies()
}