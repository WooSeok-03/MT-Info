package com.android.mtinfo.presentation.di

import com.android.mtinfo.data.api.TMDBService
import com.android.mtinfo.data.repository.movie.datasource.MovieRemoteDataSource
import com.android.mtinfo.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {
    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(
        tmdbService: TMDBService
    ): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService)
    }
}