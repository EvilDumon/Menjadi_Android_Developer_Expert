package com.example.tourismapp.di

import com.example.tourismapp.core.domain.usecase.TourismInteractor
import com.example.tourismapp.core.domain.usecase.TourismUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {
    @Binds
    abstract fun provideTourismUseCase(tourismInteractor: TourismInteractor): TourismUseCase
}