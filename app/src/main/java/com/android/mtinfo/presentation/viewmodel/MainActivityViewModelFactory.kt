package com.android.mtinfo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.mtinfo.domain.usecase.interest.DeleteInterestUseCase
import com.android.mtinfo.domain.usecase.interest.GetSavedInterestUseCase
import com.android.mtinfo.domain.usecase.interest.SaveInterestUseCase
import com.android.mtinfo.presentation.viewmodel.interest.InterestViewModel

class MainActivityViewModelFactory(
    private val saveInterestUseCase: SaveInterestUseCase,
    private val deleteInterestUseCase: DeleteInterestUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(
            saveInterestUseCase,
            deleteInterestUseCase
        ) as T
    }
}