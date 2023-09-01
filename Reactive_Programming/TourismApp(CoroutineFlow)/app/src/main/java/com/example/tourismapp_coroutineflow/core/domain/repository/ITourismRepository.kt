package com.example.tourismapp_coroutineflow.core.domain.repository

import com.example.tourismapp_coroutineflow.core.data.Resource
import com.example.tourismapp_coroutineflow.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface ITourismRepository {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flow<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}