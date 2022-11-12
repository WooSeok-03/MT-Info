package com.android.mtinfo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.mtinfo.data.model.Information
import com.android.mtinfo.domain.usecase.interest.DeleteInterestUseCase
import com.android.mtinfo.domain.usecase.interest.SaveInterestUseCase
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val saveInterestUseCase: SaveInterestUseCase,
    private val deleteInterestUseCase: DeleteInterestUseCase
): ViewModel() {

    fun saveInterest(interest: Information) = viewModelScope.launch {
        saveInterestUseCase.execute(interest)
    }

    fun deleteInterest(interest: Information) = viewModelScope.launch {
        deleteInterestUseCase.execute(interest)
    }
}