package com.dicoding.mysimplelogin

import org.koin.dsl.module

val storageModule = module {
    factory {
        SessionManager(get())
    }

    factory {
        com.dicoding.core.UserRepository(get())
    }
}
