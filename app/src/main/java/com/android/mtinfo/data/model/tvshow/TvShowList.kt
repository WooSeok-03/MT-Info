package com.android.mtinfo.data.model.tvshow

import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>

//    val page: Int,
//    val total_pages: Int,
//    val total_results: Int
)