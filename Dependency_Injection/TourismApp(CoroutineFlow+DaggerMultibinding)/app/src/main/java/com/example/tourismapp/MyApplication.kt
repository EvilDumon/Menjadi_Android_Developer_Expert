package com.example.tourismapp

import android.app.Application
import com.example.tourismapp.core.di.CoreComponent
import com.example.tourismapp.core.di.DaggerCoreComponent
import com.example.tourismapp.di.AppComponent
import com.example.tourismapp.di.DaggerAppComponent

open class MyApplication : Application() {
    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}