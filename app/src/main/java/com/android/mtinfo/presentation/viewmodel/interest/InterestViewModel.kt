package com.android.mtinfo.presentation.viewmodel.interest

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.android.mtinfo.data.model.Interest
import com.android.mtinfo.domain.usecase.interest.DeleteInterestUseCase
import com.android.mtinfo.domain.usecase.interest.GetSavedInterestUseCase
import com.android.mtinfo.domain.usecase.interest.SaveInterestUseCase
import kotlinx.coroutines.launch

class InterestViewModel(
    private val getSavedInterestUseCase: GetSavedInterestUseCase,
    private val savedInterestUseCase: SaveInterestUseCase,
    private val deleteInterestUseCase: DeleteInterestUseCase
): ViewModel() {

    fun saveInterest(interest: Interest) = viewModelScope.launch {
        savedInterestUseCase.execute(interest)
    }

    fun getSavedInterest() = liveData{
        val interestList = getSavedInterestUseCase.execute()
        emit(interestList)
    }

    fun deleteInterest(interest: Interest) = viewModelScope.launch {
        deleteInterestUseCase.execute(interest)
    }
}