package com.android.mtinfo.data.repository

import android.util.Log
import com.android.mtinfo.data.model.movie.Movie
import com.android.mtinfo.data.repository.datasource.MovieRemoteDataSource
import com.android.mtinfo.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource
): MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMovieFromAPI()
    }

    suspend fun getMovieFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body!=null){
                Log.i("Movie", "res: $response")
                Log.i("Movie", "body: $body")
                movieList = body.movies
            }
        } catch (exception: Exception) {
            Log.i("Movie", exception.message.toString())
        }
        return movieList
    }
}