package com.android.mtinfo.data.repository.datasourceImpl

import com.android.mtinfo.data.db.InterestDAO
import com.android.mtinfo.data.model.Information
import com.android.mtinfo.data.repository.datasource.InterestLocalDataSource

class InterestLocalDataSourceImpl(
    private val interestDAO: InterestDAO
): InterestLocalDataSource {
    override suspend fun saveInterestToDB(interest: Information) {
        interestDAO.insert(interest)
    }

    override fun getSavedInterest(): List<Information> {
        return interestDAO.getAllInterest()
    }

    override suspend fun deleteInterestFromDB(interest: Information) {
        interestDAO.delete(interest)
    }

}