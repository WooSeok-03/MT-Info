package com.android.mtinfo.data.repository

import android.util.Log
import com.android.mtinfo.data.model.tvshow.TvShow
import com.android.mtinfo.data.repository.datasource.TvShowRemoteDataSource
import com.android.mtinfo.domain.repository.TvShowRepository
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource
): TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowFromAPI()
    }

    override suspend fun saveTvShow(tvShow: TvShow) {

    }

    override suspend fun deleteTvShow(tvShow: TvShow) {

    }

    suspend fun getTvShowFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if(body != null) {
                Log.i("MYTAG", "$body")
                tvShowList = body.tvShows
            }
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }

        return tvShowList
    }

}