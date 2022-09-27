package com.android.mtinfo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.android.mtinfo.domain.usecase.movie.GetMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
): ViewModel() {
    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }
}