package com.example.tourismapp_coroutineflow_daggermultibinding.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.tourismapp_coroutineflow_daggermultibinding.core.domain.usecase.TourismUseCase
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(tourismUseCase: TourismUseCase) : ViewModel() {
    val favoriteTourism = tourismUseCase.getFavoriteTourism().asLiveData()
}

