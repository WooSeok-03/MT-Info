package com.android.mtinfo.presentation.viewmodel.information

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.mtinfo.domain.usecase.interest.DeleteInterestUseCase
import com.android.mtinfo.domain.usecase.interest.GetSavedInterestUseCase
import com.android.mtinfo.domain.usecase.interest.SaveInterestUseCase

class InformationViewModelFactory(
    private val getSavedInterestUseCase: GetSavedInterestUseCase,
    private val saveInterestUseCase: SaveInterestUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return InformationViewModel(
            getSavedInterestUseCase,
            saveInterestUseCase
        ) as T
    }
}