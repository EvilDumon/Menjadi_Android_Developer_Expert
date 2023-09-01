package com.example.tourismapp_reactivex.favorite

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.example.tourismapp_reactivex.core.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val favoriteTourism = LiveDataReactiveStreams.fromPublisher(tourismUseCase.getFavoriteTourism())
}

