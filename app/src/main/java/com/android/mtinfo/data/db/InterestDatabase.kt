package com.android.mtinfo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.mtinfo.data.model.Information

@Database(entities = [Information::class], version = 1, exportSchema = false)
@TypeConverters(InformationCategoryConverter::class)
abstract class InterestDatabase: RoomDatabase() {
    abstract fun interestDao(): InterestDAO
}