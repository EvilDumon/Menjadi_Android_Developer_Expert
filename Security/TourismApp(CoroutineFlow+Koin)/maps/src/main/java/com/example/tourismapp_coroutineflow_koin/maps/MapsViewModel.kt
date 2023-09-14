package com.example.tourismapp_coroutineflow_koin.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.tourismapp_coroutineflow_koin.core.domain.usecase.TourismUseCase

class MapsViewModel(tourismUseCase: TourismUseCase): ViewModel() {
    val tourism = tourismUseCase.getAllTourism().asLiveData()
}