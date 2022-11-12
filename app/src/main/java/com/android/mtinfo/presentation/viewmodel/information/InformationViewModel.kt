package com.android.mtinfo.presentation.viewmodel.information

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.android.mtinfo.data.model.Information
import com.android.mtinfo.domain.usecase.interest.DeleteInterestUseCase
import com.android.mtinfo.domain.usecase.interest.GetSavedInterestUseCase
import com.android.mtinfo.domain.usecase.interest.SaveInterestUseCase
import kotlinx.coroutines.launch

class InformationViewModel(
    private val getSavedInterestUseCase: GetSavedInterestUseCase,
    private val saveInterestUseCase: SaveInterestUseCase
): ViewModel() {

    private val _likeResult = MutableLiveData<Boolean>(false)
    val likeResult: LiveData<Boolean> get() = _likeResult

    fun getLiked(information: Information) = viewModelScope.launch {
        val result = getSavedInterestUseCase.execute(information.id)
        _likeResult.postValue(result != null)
    }

    fun likeInterest(interest: Information) = viewModelScope.launch {
        val result = saveInterestUseCase.like(interest)
        _likeResult.postValue(result != null)
    }

}