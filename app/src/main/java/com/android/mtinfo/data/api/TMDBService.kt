package com.android.mtinfo.data.api

import com.android.mtinfo.BuildConfig
import com.android.mtinfo.data.model.movie.MovieList
import com.android.mtinfo.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") api_key: String = BuildConfig.API_KEY): Response<MovieList>
    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") api_key: String = BuildConfig.API_KEY): Response<TvShowList>
}