package com.android.mtinfo.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.mtinfo.data.model.Information

@Dao
interface InterestDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(interest: Information): Long

    @Query("SELECT * FROM interest_table ORDER BY title")
    suspend fun getAllInterest(): List<Information>

    @Delete
    suspend fun delete(interest: Information): Int

    @Query("SELECT * from interest_table where id = :id")
    suspend fun getInterest(id: Int): Information?
}