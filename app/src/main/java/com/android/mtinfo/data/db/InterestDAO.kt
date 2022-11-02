package com.android.mtinfo.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.mtinfo.data.model.Interest

@Dao
interface InterestDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(interest: Interest)

    @Query("SELECT * FROM interest_table")
    fun getAllInterest(): List<Interest>

    @Delete
    fun delete(interest: Interest)
}