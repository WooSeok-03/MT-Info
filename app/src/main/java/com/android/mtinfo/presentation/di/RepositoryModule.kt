package com.android.mtinfo.presentation.di

import com.android.mtinfo.data.repository.movie.MovieRepositoryImpl
import com.android.mtinfo.data.repository.movie.datasource.MovieRemoteDataSource
import com.android.mtinfo.domain.repository.MovieRepository
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
}