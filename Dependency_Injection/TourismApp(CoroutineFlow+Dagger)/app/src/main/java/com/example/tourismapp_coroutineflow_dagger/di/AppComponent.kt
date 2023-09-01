package com.example.tourismapp_coroutineflow_dagger.di

import com.example.tourismapp_coroutineflow_dagger.core.di.CoreComponent
import com.example.tourismapp_coroutineflow_dagger.detail.DetailTourismActivity
import com.example.tourismapp_coroutineflow_dagger.favorite.FavoriteFragment
import com.example.tourismapp_coroutineflow_dagger.home.HomeFragment
import dagger.Component

@AppScope @Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
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