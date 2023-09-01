package com.dicoding.mysimplelogin_koin

import com.dicoding.core.SessionManager
import org.koin.dsl.module

val storageModule = module {
    factory {
        SessionManager(get())
    }

    factory {
        com.dicoding.core.UserRepository(get())
    }
}
