package com.android.mtinfo.presentation.viewmodel.interest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.android.mtinfo.data.model.Information
import com.android.mtinfo.domain.usecase.interest.DeleteInterestUseCase
import com.android.mtinfo.domain.usecase.interest.GetSavedInterestUseCase
import com.android.mtinfo.domain.usecase.interest.SaveInterestUseCase
import kotlinx.coroutines.launch

class InterestViewModel(
    private val getSavedInterestUseCase: GetSavedInterestUseCase
): ViewModel() {

    fun getSavedInterest() = liveData{
        val interestList = getSavedInterestUseCase.execute()
        emit(interestList)
    }
}