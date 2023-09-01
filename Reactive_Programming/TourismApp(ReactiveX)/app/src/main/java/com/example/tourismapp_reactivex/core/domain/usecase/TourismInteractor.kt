package com.example.tourismapp_reactivex.core.domain.usecase

import com.example.tourismapp_reactivex.core.data.Resource
import com.example.tourismapp_reactivex.core.domain.model.Tourism
import com.example.tourismapp_reactivex.core.domain.repository.ITourismRepository
import io.reactivex.Flowable

class TourismInteractor(private val tourismRepository: ITourismRepository): TourismUseCase {
    override fun getAllTourism(): Flowable<Resource<List<Tourism>>> {
        return tourismRepository.getAllTourism()
    }

    override fun getFavoriteTourism(): Flowable<List<Tourism>> {
        return tourismRepository.getFavoriteTourism()
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        return tourismRepository.setFavoriteTourism(tourism, state)
    }
}