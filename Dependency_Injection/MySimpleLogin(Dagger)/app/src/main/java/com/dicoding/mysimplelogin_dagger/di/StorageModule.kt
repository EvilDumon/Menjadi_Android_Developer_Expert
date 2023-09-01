package com.dicoding.mysimplelogin_dagger.di

import android.content.Context
import com.dicoding.mysimplelogin_dagger.SessionManager
import dagger.Module
import dagger.Provides

@Module
class StorageModule{
    @Provides
    fun provideSessionManager(context: Context): SessionManager = SessionManager(context)
}