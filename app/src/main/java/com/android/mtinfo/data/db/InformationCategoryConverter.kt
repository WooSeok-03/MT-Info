package com.android.mtinfo.data.db

import androidx.room.TypeConverter
import com.android.mtinfo.domain.InformationCategory

class InformationCategoryConverter {

    @TypeConverter
    fun toInformationCategory(value: String) = enumValueOf<InformationCategory>(value)

    @TypeConverter
    fun fromInformationCategory(value: InformationCategory) = value.name
}