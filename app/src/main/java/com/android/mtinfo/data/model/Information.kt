package com.android.mtinfo.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.mtinfo.data.db.InformationCategoryConverter
import com.android.mtinfo.domain.InformationCategory
import java.io.Serializable

@Entity(tableName = "interest_table")
data class Information(
    @PrimaryKey
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
    val category: InformationCategory
): Serializable
