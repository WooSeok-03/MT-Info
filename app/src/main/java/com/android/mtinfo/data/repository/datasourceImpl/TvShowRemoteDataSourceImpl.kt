package com.android.mtinfo.data.repository.datasourceImpl

import com.android.mtinfo.data.api.TMDBService
import com.android.mtinfo.data.model.tvshow.TvShowList
import com.android.mtinfo.data.repository.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService
): TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows()
}