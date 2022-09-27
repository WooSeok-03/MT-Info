package com.android.mtinfo.presentation.viewmodel.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.android.mtinfo.domain.usecase.tvshow.GetTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase
): ViewModel() {
    fun getTvShow() = liveData {
        val tvShow = getTvShowsUseCase.execute()
        emit(tvShow)
    }
}