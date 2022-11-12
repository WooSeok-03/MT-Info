package com.android.mtinfo.domain.usecase.interest

import com.android.mtinfo.data.model.Information
import com.android.mtinfo.domain.repository.InterestRepository

class SaveInterestUseCase(private val insertRepository: InterestRepository) {
    suspend fun execute(interest: Information): Long {
        return insertRepository.saveInterest(interest)
    }

    suspend fun like(interest: Information): Information? {
        return insertRepository.likeInterest(interest)
    }
}