package com.android.mtinfo.data.repository.datasource

import com.android.mtinfo.data.model.Information

interface InterestLocalDataSource {
    suspend fun saveInterestToDB(interest: Information)
    fun getSavedInterest(): List<Information>
    suspend fun deleteInterestFromDB(interest: Information)
}