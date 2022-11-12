package com.android.mtinfo.data.repository

import android.util.Log
import com.android.mtinfo.data.model.Information
import com.android.mtinfo.data.repository.datasource.InterestLocalDataSource
import com.android.mtinfo.domain.repository.InterestRepository

class InterestRepositoryImpl(
    private val interestLocalDataSource: InterestLocalDataSource
): InterestRepository {
    override suspend fun likeInterest(interest: Information): Information? {
        val isLiked = getInterestById(interest.id) != null
        val affectedRow =
            if(isLiked) deleteInterest(interest).toLong()
            else saveInterest(interest)

        return if(affectedRow > 0) {
            if(isLiked) null
            else interest
        } else {
            null
        }
    }

    override suspend fun getInterestById(id: Int): Information? {
        return interestLocalDataSource.getSavedInterestById(id)
    }

    override suspend fun getInterest(): List<Information> {
        return interestLocalDataSource.getSavedInterest()
    }

    override suspend fun saveInterest(interest: Information) =
        interestLocalDataSource.saveInterestToDB(interest)

    override suspend fun deleteInterest(interest: Information) =
        interestLocalDataSource.deleteInterestFromDB(interest)
}