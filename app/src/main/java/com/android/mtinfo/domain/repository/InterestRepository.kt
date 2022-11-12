package com.android.mtinfo.domain.repository

import com.android.mtinfo.data.model.Information

interface InterestRepository {
    suspend fun likeInterest(interest: Information): Information?
    suspend fun getInterestById(id: Int): Information?
    suspend fun getInterest(): List<Information>
    suspend fun saveInterest(interest: Information): Long
    suspend fun deleteInterest(interest: Information): Int
}