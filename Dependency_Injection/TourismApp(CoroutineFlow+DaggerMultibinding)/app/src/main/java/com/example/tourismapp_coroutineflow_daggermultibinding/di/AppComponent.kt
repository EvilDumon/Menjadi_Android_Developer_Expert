package com.example.tourismapp_coroutineflow_daggermultibinding.di

import com.example.tourismapp_coroutineflow_daggermultibinding.core.di.CoreComponent
import com.example.tourismapp_coroutineflow_daggermultibinding.detail.DetailTourismActivity
import com.example.tourismapp_coroutineflow_daggermultibinding.favorite.FavoriteFragment
import com.example.tourismapp_coroutineflow_daggermultibinding.home.HomeFragment
import dagger.Component

@AppScope @Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(activity: DetailTourismActivity)
}