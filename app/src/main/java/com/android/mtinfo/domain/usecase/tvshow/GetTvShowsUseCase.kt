package com.android.mtinfo.domain.usecase.tvshow

import com.android.mtinfo.data.model.tvshow.TvShow
import com.android.mtinfo.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}