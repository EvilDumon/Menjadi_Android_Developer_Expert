package com.example.tourismapp_coroutineflow_koin.core.domain.usecase

import com.example.tourismapp_coroutineflow_koin.core.data.Resource
import com.example.tourismapp_coroutineflow_koin.core.domain.model.Tourism
import com.example.tourismapp_coroutineflow_koin.core.domain.repository.ITourismRepository
import kotlinx.coroutines.flow.Flow

class TourismInteractor(private val tourismRepository: ITourismRepository): TourismUseCase {
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