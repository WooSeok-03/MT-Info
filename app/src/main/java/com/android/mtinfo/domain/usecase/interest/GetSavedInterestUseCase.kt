package com.android.mtinfo.domain.usecase.interest

import com.android.mtinfo.data.model.Information
import com.android.mtinfo.domain.repository.InterestRepository

class GetSavedInterestUseCase(private val interestRepository: InterestRepository) {
    fun execute(): List<Information> {
        return interestRepository.getInterest()
    }
}