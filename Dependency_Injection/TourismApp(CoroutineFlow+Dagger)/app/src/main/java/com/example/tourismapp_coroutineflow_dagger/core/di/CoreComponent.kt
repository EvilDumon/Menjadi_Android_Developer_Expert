package com.example.tourismapp_coroutineflow_dagger.core.di

import android.content.Context
import com.example.tourismapp_coroutineflow_dagger.core.domain.repository.ITourismRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton @Component( modules = [RepositoryModule::class] )
interface CoreComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun provideRepository(): ITourismRepository
}