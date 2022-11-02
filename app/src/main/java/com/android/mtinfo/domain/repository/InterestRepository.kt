package com.android.mtinfo.domain.repository

import com.android.mtinfo.data.model.Interest

interface InterestRepository {
    fun getInterest(): List<Interest>
    suspend fun saveInterest(interest: Interest)
    suspend fun deleteInterest(interest: Interest)
}