package com.android.mtinfo.domain.repository

import com.android.mtinfo.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun saveTvShow(tvShow: TvShow)
    suspend fun deleteTvShow(tvShow: TvShow)
}