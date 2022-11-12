package com.android.mtinfo.data.repository.datasource

import com.android.mtinfo.data.model.Information

interface InterestLocalDataSource {
    suspend fun getSavedInterest(): List<Information>
    suspend fun getSavedInterestById(id: Int): Information?
    suspend fun saveInterestToDB(interest: Information): Long
    suspend fun deleteInterestFromDB(interest: Information): Int
}