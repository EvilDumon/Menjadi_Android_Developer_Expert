package com.dicoding.mysimplelogin_dagger

import android.app.Application
import com.dicoding.mysimplelogin_dagger.di.AppComponent
import com.dicoding.mysimplelogin_dagger.di.DaggerAppComponent

open class MyApplication: Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}