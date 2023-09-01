package com.example.tourismapp_coroutineflow_dagger.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.tourismapp_coroutineflow_dagger.core.domain.usecase.TourismUseCase
class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val favoriteTourism = tourismUseCase.getFavoriteTourism().asLiveData()
}

