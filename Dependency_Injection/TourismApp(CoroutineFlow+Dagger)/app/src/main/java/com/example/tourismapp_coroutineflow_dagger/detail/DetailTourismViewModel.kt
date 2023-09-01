package com.example.tourismapp_coroutineflow_dagger.detail

import androidx.lifecycle.ViewModel
import com.example.tourismapp_coroutineflow_dagger.core.domain.model.Tourism
import com.example.tourismapp_coroutineflow_dagger.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(private val tourismUseCase: TourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) = tourismUseCase.setFavoriteTourism(tourism, newStatus)
}