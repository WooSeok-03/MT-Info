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

    override suspend fun saveMovie(movie: Movie) {
    }

    override suspend fun deleteMovie(movie: Movie) {
    }

    suspend fun getMovieFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body!=null){
                Log.i("MYTAG", "res: $response")
                Log.i("MYTAG", "body: $body")
                movieList = body.movies
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return movieList
    }
}