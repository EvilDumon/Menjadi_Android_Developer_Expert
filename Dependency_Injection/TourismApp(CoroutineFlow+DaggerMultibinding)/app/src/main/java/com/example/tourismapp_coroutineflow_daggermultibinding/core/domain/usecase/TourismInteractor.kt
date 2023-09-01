package com.example.tourismapp_coroutineflow_daggermultibinding.core.domain.usecase

import com.example.tourismapp_coroutineflow_daggermultibinding.core.data.Resource
import com.example.tourismapp_coroutineflow_daggermultibinding.core.domain.model.Tourism
import com.example.tourismapp_coroutineflow_daggermultibinding.core.domain.repository.ITourismRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TourismInteractor @Inject constructor(private val tourismRepository: ITourismRepository): TourismUseCase {
    override fun getAllTourism(): Flow<Resource<List<Tourism>>> {
        return tourismRepository.getAllTourism()
    }

    override fun getFavoriteTourism(): Flow<List<Tourism>> {
        return tourismRepository.getFavoriteTourism()
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        return tourismRepository.setFavoriteTourism(tourism, state)
    }
}