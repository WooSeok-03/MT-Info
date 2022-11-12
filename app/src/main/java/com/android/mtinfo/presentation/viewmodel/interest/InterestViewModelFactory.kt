package com.android.mtinfo.presentation.viewmodel.interest

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.mtinfo.domain.usecase.interest.DeleteInterestUseCase
import com.android.mtinfo.domain.usecase.interest.GetSavedInterestUseCase
import com.android.mtinfo.domain.usecase.interest.SaveInterestUseCase

class InterestViewModelFactory(
    private val getSavedInterestUseCase: GetSavedInterestUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return InterestViewModel(
            getSavedInterestUseCase
        ) as T
    }
}