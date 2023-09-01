package com.example.tourismapp_coroutineflow_hilt.detail

import androidx.lifecycle.ViewModel
import com.example.tourismapp_coroutineflow_hilt.core.domain.model.Tourism
import com.example.tourismapp_coroutineflow_hilt.core.domain.usecase.TourismUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailTourismViewModel @Inject constructor(private val tourismUseCase: TourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) = tourismUseCase.setFavoriteTourism(tourism, newStatus)
}