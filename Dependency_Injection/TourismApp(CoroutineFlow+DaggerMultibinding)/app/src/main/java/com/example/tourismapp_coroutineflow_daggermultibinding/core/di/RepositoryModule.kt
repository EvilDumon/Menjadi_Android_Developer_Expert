package com.example.tourismapp_coroutineflow_daggermultibinding.core.di

import com.example.tourismapp_coroutineflow_daggermultibinding.core.data.TourismRepository
import com.example.tourismapp_coroutineflow_daggermultibinding.core.domain.repository.ITourismRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(tourismRepository: TourismRepository): ITourismRepository
}