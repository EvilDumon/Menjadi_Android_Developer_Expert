package com.example.tourismapp_coroutineflow_hilt.core.di

import com.example.tourismapp_coroutineflow_hilt.core.data.TourismRepository
import com.example.tourismapp_coroutineflow_hilt.core.domain.repository.ITourismRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module @InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(tourismRepository: TourismRepository): ITourismRepository
}