package com.android.mtinfo.presentation.di

import com.android.mtinfo.data.repository.MovieRepositoryImpl
import com.android.mtinfo.data.repository.TvShowRepositoryImpl
import com.android.mtinfo.data.repository.datasource.MovieRemoteDataSource
import com.android.mtinfo.data.repository.datasource.TvShowRemoteDataSource
import com.android.mtinfo.domain.repository.MovieRepository
import com.android.mtinfo.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(tvShowRemoteDataSource)
    }
}