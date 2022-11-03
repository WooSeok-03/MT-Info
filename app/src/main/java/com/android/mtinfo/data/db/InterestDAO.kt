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
    fun insert(interest: Information)

    @Query("SELECT * FROM interest_table")
    fun getAllInterest(): List<Information>

    @Delete
    fun delete(interest: Information)
}