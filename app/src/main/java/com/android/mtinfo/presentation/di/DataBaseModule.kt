package com.android.mtinfo.presentation.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.android.mtinfo.data.db.InterestDAO
import com.android.mtinfo.data.db.InterestDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideInterestDatabase(app: Application): InterestDatabase {
        return Room.databaseBuilder(app, InterestDatabase::class.java, "tmdbclient")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideInterestDao(interestDatabase: InterestDatabase): InterestDAO {
        return interestDatabase.interestDao()
    }
}