package com.example.tourismapp.di

import com.example.tourismapp.core.di.CoreComponent
import com.example.tourismapp.detail.DetailTourismActivity
import com.example.tourismapp.favorite.FavoriteFragment
import com.example.tourismapp.home.HomeFragment
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