package com.android.mtinfo.data.model.tvshow

import com.google.gson.annotations.SerializedName

data class TvShowList(
    val page: Int,
    @SerializedName("result")
    val tvShows: List<TvShow>,
    val total_pages: Int,
    val total_results: Int
)