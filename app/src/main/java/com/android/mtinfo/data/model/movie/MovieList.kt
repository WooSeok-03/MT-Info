package com.android.mtinfo.data.model.movie

import com.android.mtinfo.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("result")
    val movies: List<Movie>

//    val page: Int,
//    val total_pages: Int,
//    val total_results: Int
)