package com.example.tourismapp_reactivex.core.domain.repository

import com.example.tourismapp_reactivex.core.data.Resource
import com.example.tourismapp_reactivex.core.domain.model.Tourism
import io.reactivex.Flowable

interface ITourismRepository {

    fun getAllTourism(): Flowable<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flowable<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}