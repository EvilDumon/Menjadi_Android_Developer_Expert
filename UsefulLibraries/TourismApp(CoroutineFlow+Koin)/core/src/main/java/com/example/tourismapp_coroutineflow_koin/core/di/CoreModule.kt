package com.example.tourismapp_coroutineflow_koin.core.di

import androidx.room.Room
import com.example.tourismapp_coroutineflow_koin.core.data.TourismRepository
import com.example.tourismapp_coroutineflow_koin.core.data.source.local.LocalDataSource
import com.example.tourismapp_coroutineflow_koin.core.data.source.local.room.TourismDatabase
import com.example.tourismapp_coroutineflow_koin.core.data.source.remote.RemoteDataSource
import com.example.tourismapp_coroutineflow_koin.core.data.source.remote.network.ApiService
import com.example.tourismapp_coroutineflow_koin.core.domain.repository.ITourismRepository
import com.example.tourismapp_coroutineflow_koin.core.utils.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<TourismDatabase>().tourismDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            TourismDatabase::class.java, "Tourism.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val hostname = "tourism-api.dicoding.dev"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/Y+Vndm0REOT/lc8fwv2u3cgwM3+J/rbAOl0tfNo4cmM=")
            .add(hostname, "sha256/jQJTbIh0grw0/1TkHSumWb+Fs0Ggogr621gT3PvPKG0=")
            .add(hostname, "sha256/C5+lpZ7tcVwmwQIMcRtPbsQtWLABXhQzejna0wHFr8M=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://tourism-api.dicoding.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    factory { AppExecutors() }
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    single<ITourismRepository> {
        TourismRepository(
            get(),
            get(),
            get()
        )
    }
}