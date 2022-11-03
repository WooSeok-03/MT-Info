package com.android.mtinfo.domain.repository

import com.android.mtinfo.data.model.Information

interface InterestRepository {
    fun getInterest(): List<Information>
    suspend fun saveInterest(interest: Information)
    suspend fun deleteInterest(interest: Information)
}