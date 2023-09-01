package com.example.tourismapp_coroutineflow_dagger

import android.app.Application
import com.example.tourismapp_coroutineflow_dagger.core.di.CoreComponent
import com.example.tourismapp_coroutineflow_dagger.core.di.DaggerCoreComponent
import com.example.tourismapp_coroutineflow_dagger.di.AppComponent
import com.example.tourismapp_coroutineflow_dagger.di.DaggerAppComponent

open class MyApplication : Application() {
    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}