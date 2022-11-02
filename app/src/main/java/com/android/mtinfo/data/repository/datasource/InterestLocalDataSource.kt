package com.android.mtinfo.data.repository.datasource

import com.android.mtinfo.data.model.Interest

interface InterestLocalDataSource {
    suspend fun saveInterestToDB(interest: Interest)
    fun getSavedInterest(): List<Interest>
    suspend fun deleteInterestFromDB(interest: Interest)
}