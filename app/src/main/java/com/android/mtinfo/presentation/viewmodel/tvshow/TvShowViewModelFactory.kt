package com.android.mtinfo.presentation.viewmodel.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.mtinfo.domain.usecase.tvshow.GetTvShowsUseCase

class TvShowViewModelFactory(
    private val tvShowsUseCase: GetTvShowsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(tvShowsUseCase) as T
    }
}