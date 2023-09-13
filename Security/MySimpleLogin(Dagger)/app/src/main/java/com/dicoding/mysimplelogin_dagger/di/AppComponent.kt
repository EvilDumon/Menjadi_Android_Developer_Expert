package com.dicoding.mysimplelogin_dagger.di

import android.content.Context
import com.dicoding.mysimplelogin_dagger.HomeActivity
import com.dicoding.mysimplelogin_dagger.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton @Component(modules = [StorageModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
    fun inject(activity: MainActivity)
    fun inject(activity: HomeActivity)
}