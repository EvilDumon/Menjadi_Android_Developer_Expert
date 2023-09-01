package com.example.tourismapp_coroutineflow_daggermultibinding.core.domain.repository

import com.example.tourismapp_coroutineflow_daggermultibinding.core.data.Resource
import com.example.tourismapp_coroutineflow_daggermultibinding.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface ITourismRepository {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flow<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}