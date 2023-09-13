package com.example.tourismapp_coroutineflow_koin.core.data

import com.example.tourismapp_coroutineflow_koin.core.data.source.local.LocalDataSource
import com.example.tourismapp_coroutineflow_koin.core.data.source.remote.RemoteDataSource
import com.example.tourismapp_coroutineflow_koin.core.data.source.remote.network.ApiResponse
import com.example.tourismapp_coroutineflow_koin.core.data.source.remote.response.TourismResponse
import com.example.tourismapp_coroutineflow_koin.core.domain.model.Tourism
import com.example.tourismapp_coroutineflow_koin.core.domain.repository.ITourismRepository
import com.example.tourismapp_coroutineflow_koin.core.utils.AppExecutors
import com.example.tourismapp_coroutineflow_koin.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TourismRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: com.example.tourismapp_coroutineflow_koin.core.data.source.local.LocalDataSource,
    private val appExecutors: AppExecutors
): ITourismRepository {

    companion object {
        @Volatile
        private var instance: com.example.tourismapp_coroutineflow_koin.core.data.TourismRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: com.example.tourismapp_coroutineflow_koin.core.data.source.local.LocalDataSource,
            appExecutors: AppExecutors
        ): com.example.tourismapp_coroutineflow_koin.core.data.TourismRepository =
            com.example.tourismapp_coroutineflow_koin.core.data.TourismRepository.Companion.instance
                ?: synchronized(this) {
                com.example.tourismapp_coroutineflow_koin.core.data.TourismRepository.Companion.instance
                    ?: com.example.tourismapp_coroutineflow_koin.core.data.TourismRepository(
                        remoteData,
                        localData,
                        appExecutors
                    )
            }
    }

    override fun getAllTourism(): Flow<com.example.tourismapp_coroutineflow_koin.core.data.Resource<List<Tourism>>> =
        object : com.example.tourismapp_coroutineflow_koin.core.data.NetworkBoundResource<List<Tourism>, List<TourismResponse>>() {
            override fun loadFromDB(): Flow<List<Tourism>> {
                return localDataSource.getAllTourism().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Tourism>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TourismResponse>>> =
                remoteDataSource.getAllTourism()

            override suspend fun saveCallResult(data: List<TourismResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asFlow()

    override fun getFavoriteTourism(): Flow<List<Tourism>> {
        return localDataSource.getFavoriteTourism().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
    }
}