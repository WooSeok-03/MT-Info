package com.android.mtinfo.presentation.di

import android.app.Application
import com.android.mtinfo.domain.usecase.interest.DeleteInterestUseCase
import com.android.mtinfo.domain.usecase.interest.GetSavedInterestUseCase
import com.android.mtinfo.domain.usecase.interest.SaveInterestUseCase
import com.android.mtinfo.domain.usecase.movie.GetMoviesUseCase
import com.android.mtinfo.domain.usecase.tvshow.GetTvShowsUseCase
import com.android.mtinfo.presentation.viewmodel.interest.InterestViewModelFactory
import com.android.mtinfo.presentation.viewmodel.movie.MovieViewModelFactory
import com.android.mtinfo.presentation.viewmodel.tvshow.TvShowViewModel
import com.android.mtinfo.presentation.viewmodel.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase)
    }

    @Singleton
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase)
    }

    @Singleton
    @Provides
    fun provideInterestViewModelFactory(
        getSavedInterestUseCase: GetSavedInterestUseCase,
        saveInterestUseCase: SaveInterestUseCase,
        deleteInterestUseCase: DeleteInterestUseCase
    ): InterestViewModelFactory {
        return InterestViewModelFactory(
            getSavedInterestUseCase,
            saveInterestUseCase,
            deleteInterestUseCase
        )
    }
}