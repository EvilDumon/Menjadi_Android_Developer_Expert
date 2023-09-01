package com.example.tourismapp_coroutineflow_daggermultibinding.di

import com.example.tourismapp_coroutineflow_daggermultibinding.core.domain.usecase.TourismInteractor
import com.example.tourismapp_coroutineflow_daggermultibinding.core.domain.usecase.TourismUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {
    @Binds
    abstract fun provideTourismUseCase(tourismInteractor: TourismInteractor): TourismUseCase
}