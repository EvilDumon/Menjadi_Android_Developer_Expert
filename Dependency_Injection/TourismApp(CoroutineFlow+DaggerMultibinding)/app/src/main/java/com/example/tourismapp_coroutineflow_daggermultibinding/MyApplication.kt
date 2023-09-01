package com.example.tourismapp_coroutineflow_daggermultibinding

import android.app.Application
import com.example.tourismapp_coroutineflow_daggermultibinding.core.di.CoreComponent
import com.example.tourismapp_coroutineflow_daggermultibinding.core.di.DaggerCoreComponent
import com.example.tourismapp_coroutineflow_daggermultibinding.di.AppComponent
import com.example.tourismapp_coroutineflow_daggermultibinding.di.DaggerAppComponent

open class MyApplication : Application() {
    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}