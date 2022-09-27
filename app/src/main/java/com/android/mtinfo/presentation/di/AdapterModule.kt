package com.android.mtinfo.presentation.di

import com.android.mtinfo.presentation.adapter.MovieAdapter
import com.android.mtinfo.presentation.adapter.TvShowAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {
    @Singleton
    @Provides
    fun provideMovieAdapter(): MovieAdapter {
        return MovieAdapter()
    }

    @Singleton
    @Provides
    fun provideTvShowAdapter(): TvShowAdapter {
        return TvShowAdapter()
    }
}