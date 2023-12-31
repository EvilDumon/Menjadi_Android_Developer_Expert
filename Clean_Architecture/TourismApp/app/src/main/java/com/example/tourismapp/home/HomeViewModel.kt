package com.example.tourismapp.home

import androidx.lifecycle.ViewModel
import com.example.tourismapp.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism()
}

