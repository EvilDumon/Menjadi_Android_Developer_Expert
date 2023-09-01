package com.example.tourismapp_coroutineflow_dagger.di

import com.example.tourismapp_coroutineflow_dagger.core.domain.usecase.TourismInteractor
import com.example.tourismapp_coroutineflow_dagger.core.domain.usecase.TourismUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {
    @Binds
    abstract fun provideTourismUseCase(tourismInteractor: TourismInteractor): TourismUseCase
}