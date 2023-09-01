package com.example.tourismapp_coroutineflow_daggermultibinding.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.tourismapp_coroutineflow_daggermultibinding.core.domain.usecase.TourismUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism().asLiveData()
}

