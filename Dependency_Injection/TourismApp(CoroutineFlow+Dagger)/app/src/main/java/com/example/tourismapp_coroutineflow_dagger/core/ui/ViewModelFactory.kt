package com.example.tourismapp_coroutineflow_dagger.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tourismapp_coroutineflow_dagger.core.domain.usecase.TourismUseCase
import com.example.tourismapp_coroutineflow_dagger.detail.DetailTourismViewModel
import com.example.tourismapp_coroutineflow_dagger.di.AppScope
import com.example.tourismapp_coroutineflow_dagger.favorite.FavoriteViewModel
import com.example.tourismapp_coroutineflow_dagger.home.HomeViewModel
import javax.inject.Inject

@AppScope
class ViewModelFactory @Inject constructor(private val tourismUseCase: TourismUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(tourismUseCase) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(tourismUseCase) as T
            }
            modelClass.isAssignableFrom(DetailTourismViewModel::class.java) -> {
                DetailTourismViewModel(tourismUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}