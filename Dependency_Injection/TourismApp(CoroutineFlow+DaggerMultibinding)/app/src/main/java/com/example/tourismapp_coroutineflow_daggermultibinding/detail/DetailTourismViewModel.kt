package com.example.tourismapp_coroutineflow_daggermultibinding.detail

import androidx.lifecycle.ViewModel
import com.example.tourismapp_coroutineflow_daggermultibinding.core.domain.model.Tourism
import com.example.tourismapp_coroutineflow_daggermultibinding.core.domain.usecase.TourismUseCase
import javax.inject.Inject

class DetailTourismViewModel @Inject constructor(private val tourismUseCase: TourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) = tourismUseCase.setFavoriteTourism(tourism, newStatus)
}