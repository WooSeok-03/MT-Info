package com.android.mtinfo.data.repository

import com.android.mtinfo.data.model.Information
import com.android.mtinfo.data.repository.datasource.InterestLocalDataSource
import com.android.mtinfo.domain.repository.InterestRepository

class InterestRepositoryImpl(
    private val interestLocalDataSource: InterestLocalDataSource
): InterestRepository {
    override fun getInterest(): List<Information> {
        return interestLocalDataSource.getSavedInterest()
    }

    override suspend fun saveInterest(interest: Information) {
        interestLocalDataSource.saveInterestToDB(interest)
    }

    override suspend fun deleteInterest(interest: Information) {
        interestLocalDataSource.deleteInterestFromDB(interest)
    }
}