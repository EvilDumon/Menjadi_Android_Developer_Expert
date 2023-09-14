package com.example.tourismapp_coroutineflow_koin.core.data.source.remote

import com.example.tourismapp_coroutineflow_koin.core.data.source.remote.response.TourismResponse
import com.google.gson.annotations.SerializedName

data class ListTourismResponse(
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("places")
    val places: List<TourismResponse>
)