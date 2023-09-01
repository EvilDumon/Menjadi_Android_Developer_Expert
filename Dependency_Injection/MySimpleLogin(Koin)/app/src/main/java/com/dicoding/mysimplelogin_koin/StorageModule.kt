package com.dicoding.mysimplelogin_koin

import org.koin.dsl.module

val storageModule = module {
    factory {
        SessionManager(get())
    }

    factory {
        UserRepository(get())
    }
}
