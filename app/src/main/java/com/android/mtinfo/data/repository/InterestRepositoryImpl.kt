package com.android.mtinfo.data.repository

import com.android.mtinfo.data.model.Interest
import com.android.mtinfo.data.repository.datasource.InterestLocalDataSource
import com.android.mtinfo.domain.repository.InterestRepository

class InterestRepositoryImpl(
    private val interestLocalDataSource: InterestLocalDataSource
): InterestRepository {
    override fun getInterest(): List<Interest> {
        return interestLocalDataSource.getSavedInterest()
    }

    override suspend fun saveInterest(interest: Interest) {
        interestLocalDataSource.saveInterestToDB(interest)
    }

    override suspend fun deleteInterest(interest: Interest) {
        interestLocalDataSource.deleteInterestFromDB(interest)
    }
}