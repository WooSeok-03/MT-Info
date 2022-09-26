package com.android.mtinfo.data.model.movie

import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)

//    val page: Int,
//    val total_pages: Int,
//    val total_results: Int