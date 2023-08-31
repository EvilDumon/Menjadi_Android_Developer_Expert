package com.example.tourismapp.core.data.source.remote.network

import com.example.tourismapp.core.data.source.remote.ListTourismResponse
import retrofit2.http.GET

interface ApiService {
    @GET("list")
    suspend fun getList(): ListTourismResponse
}