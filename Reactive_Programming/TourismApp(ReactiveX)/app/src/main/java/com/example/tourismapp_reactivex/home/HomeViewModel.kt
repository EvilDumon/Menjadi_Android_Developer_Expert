package com.example.tourismapp_reactivex.home

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.example.tourismapp_reactivex.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = LiveDataReactiveStreams.fromPublisher(tourismUseCase.getAllTourism())
}

