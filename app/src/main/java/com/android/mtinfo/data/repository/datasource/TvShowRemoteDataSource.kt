package com.android.mtinfo.data.repository.datasource

import com.android.mtinfo.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}