package com.android.mtinfo.domain.usecase.interest

import androidx.room.Insert
import com.android.mtinfo.data.model.Interest
import com.android.mtinfo.domain.repository.InterestRepository

class SaveInterestUseCase(private val insertRepository: InterestRepository) {
    suspend fun execute(interest: Interest) {
        insertRepository.saveInterest(interest)
    }
}