package com.android.mtinfo.presentation.di

import com.android.mtinfo.domain.repository.InterestRepository
import com.android.mtinfo.domain.repository.MovieRepository
import com.android.mtinfo.domain.repository.TvShowRepository
import com.android.mtinfo.domain.usecase.interest.DeleteInterestUseCase
import com.android.mtinfo.domain.usecase.interest.GetSavedInterestUseCase
import com.android.mtinfo.domain.usecase.interest.SaveInterestUseCase
import com.android.mtinfo.domain.usecase.movie.GetMoviesUseCase
import com.android.mtinfo.domain.usecase.tvshow.GetTvShowsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideGetTvShowsUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Singleton
    @Provides
    fun provideGetSavedInterestUseCase(
        interestRepository: InterestRepository
    ): GetSavedInterestUseCase {
        return GetSavedInterestUseCase(interestRepository)
    }

    @Singleton
    @Provides
    fun provideSaveInterestUseCase(
        interestRepository: InterestRepository
    ): SaveInterestUseCase {
        return SaveInterestUseCase(interestRepository)
    }

    @Singleton
    @Provides
    fun provideDeleteInterestUseCase(
        interestRepository: InterestRepository
    ): DeleteInterestUseCase {
        return DeleteInterestUseCase(interestRepository)
    }
}