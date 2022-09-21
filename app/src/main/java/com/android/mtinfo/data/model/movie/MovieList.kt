package com.android.mtinfo.data.model.movie

import com.android.mtinfo.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    val page: Int,
    @SerializedName("result")
    val movies: List<Movie>,
//    val total_pages: Int,
//    val total_results: Int
)