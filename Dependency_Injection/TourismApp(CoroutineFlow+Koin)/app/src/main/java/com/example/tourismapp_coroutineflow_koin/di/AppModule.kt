package com.example.tourismapp_coroutineflow_koin.di

import com.example.tourismapp_coroutineflow_koin.core.domain.usecase.TourismInteractor
import com.example.tourismapp_coroutineflow_koin.core.domain.usecase.TourismUseCase
import com.example.tourismapp_coroutineflow_koin.detail.DetailTourismViewModel
import com.example.tourismapp_coroutineflow_koin.favorite.FavoriteViewModel
import com.example.tourismapp_coroutineflow_koin.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TourismUseCase>{ TourismInteractor(get())}
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailTourismViewModel(get()) }
}