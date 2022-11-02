package com.android.mtinfo.presentation.di

import com.android.mtinfo.data.db.InterestDAO
import com.android.mtinfo.data.repository.datasource.InterestLocalDataSource
import com.android.mtinfo.data.repository.datasourceImpl.InterestLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Singleton
    @Provides
    fun provideInterestLocalDataSource(interestDAO: InterestDAO): InterestLocalDataSource {
        return InterestLocalDataSourceImpl(interestDAO)
    }
}