package com.android.mtinfo.domain.usecase.interest

import com.android.mtinfo.data.model.Interest
import com.android.mtinfo.domain.repository.InterestRepository

class DeleteInterestUseCase(private val interestRepository: InterestRepository) {
    suspend fun execute(interest: Interest) {
        interestRepository.deleteInterest(interest)
    }
}