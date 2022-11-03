package com.android.mtinfo.domain.usecase.interest

import com.android.mtinfo.data.model.Information
import com.android.mtinfo.domain.repository.InterestRepository

class DeleteInterestUseCase(private val interestRepository: InterestRepository) {
    suspend fun execute(interest: Information) {
        interestRepository.deleteInterest(interest)
    }
}