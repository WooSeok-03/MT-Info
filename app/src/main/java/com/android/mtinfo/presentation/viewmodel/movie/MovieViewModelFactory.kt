package com.android.mtinfo.presentation.viewmodel.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.mtinfo.domain.usecase.movie.GetMoviesUseCase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase) as T
    }
}