package com.android.mtinfo.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "interest_table")
data class Interest(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
    val category: String        // Movie or TV
)
