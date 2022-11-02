package com.android.mtinfo.data.repository.datasourceImpl

import com.android.mtinfo.data.db.InterestDAO
import com.android.mtinfo.data.model.Interest
import com.android.mtinfo.data.repository.datasource.InterestLocalDataSource

class InterestLocalDataSourceImpl(
    private val interestDAO: InterestDAO
): InterestLocalDataSource {
    override suspend fun saveInterestToDB(interest: Interest) {
        interestDAO.insert(interest)
    }

    override fun getSavedInterest(): List<Interest> {
        return interestDAO.getAllInterest()
    }

    override suspend fun deleteInterestFromDB(interest: Interest) {
        interestDAO.delete(interest)
    }

}