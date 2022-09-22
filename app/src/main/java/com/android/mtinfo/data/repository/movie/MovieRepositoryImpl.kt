package com.android.mtinfo.data.repository.movie

import android.util.Log
import com.android.mtinfo.data.model.movie.Movie
import com.android.mtinfo.data.repository.movie.datasource.MovieRemoteDataSource
import com.android.mtinfo.domain.repository.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource
): MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMovieFromAPI()
    }

    override suspend fun saveMovie(movie: Movie) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMovie(movie: Movie) {
        TODO("Not yet implemented")
    }

    suspend fun getMovieFromAPI(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body != null) movieList = body.movies
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        return movieList
    }
}