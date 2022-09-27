package com.android.mtinfo.presentation.di

import com.android.mtinfo.data.api.TMDBService
import com.android.mtinfo.data.repository.datasource.MovieRemoteDataSource
import com.android.mtinfo.data.repository.datasource.TvShowRemoteDataSource
import com.android.mtinfo.data.repository.datasourceImpl.MovieRemoteDataSourceImpl
import com.android.mtinfo.data.repository.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(
        tmdbService: TMDBService
    ): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(
        tmdbService: TMDBService
    ): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService)
    }
}