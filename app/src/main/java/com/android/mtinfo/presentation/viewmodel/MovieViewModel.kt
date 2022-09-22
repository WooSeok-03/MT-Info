package com.android.mtinfo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.android.mtinfo.domain.usecase.movie.GetMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
): ViewModel() {

}