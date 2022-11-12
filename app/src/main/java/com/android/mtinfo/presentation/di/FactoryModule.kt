package com.android.mtinfo.presentation.di

import android.app.Application
import com.android.mtinfo.domain.usecase.interest.DeleteInterestUseCase
import com.android.mtinfo.domain.usecase.interest.GetSavedInterestUseCase
import com.android.mtinfo.domain.usecase.interest.SaveInterestUseCase
import com.android.mtinfo.domain.usecase.movie.GetMoviesUseCase
import com.android.mtinfo.domain.usecase.tvshow.GetTvShowsUseCase
import com.android.mtinfo.presentation.viewmodel.MainActivityViewModel
import com.android.mtinfo.presentation.viewmodel.MainActivityViewModelFactory
import com.android.mtinfo.presentation.viewmodel.information.InformationViewModelFactory
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
        getSavedInterestUseCase: GetSavedInterestUseCase
    ): InterestViewModelFactory {
        return InterestViewModelFactory(
            getSavedInterestUseCase
        )
    }

    @Singleton
    @Provides
    fun provideMainViewModelFactory(
        saveInterestUseCase: SaveInterestUseCase,
        deleteInterestUseCase: DeleteInterestUseCase
    ): MainActivityViewModelFactory {
        return MainActivityViewModelFactory(
            saveInterestUseCase,
            deleteInterestUseCase
        )
    }

    @Singleton
    @Provides
    fun provideInformationViewModelFactory(
        getSavedInterestUseCase: GetSavedInterestUseCase,
        saveInterestUseCase: SaveInterestUseCase
    ): InformationViewModelFactory {
        return InformationViewModelFactory(
            getSavedInterestUseCase,
            saveInterestUseCase
        )
    }
}