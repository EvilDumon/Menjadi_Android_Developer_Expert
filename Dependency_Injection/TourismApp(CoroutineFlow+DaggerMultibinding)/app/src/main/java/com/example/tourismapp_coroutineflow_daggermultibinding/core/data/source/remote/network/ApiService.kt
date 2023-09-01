package com.example.tourismapp_coroutineflow_daggermultibinding.core.data.source.remote.network

import com.example.tourismapp_coroutineflow_daggermultibinding.core.data.source.remote.response.ListTourismResponse
import retrofit2.http.GET

interface ApiService {
    @GET("list")
    suspend fun getList(): ListTourismResponse
}