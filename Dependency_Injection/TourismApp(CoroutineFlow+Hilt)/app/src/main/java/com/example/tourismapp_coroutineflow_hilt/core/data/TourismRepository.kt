package com.example.tourismapp_coroutineflow_hilt.core.data

import com.example.tourismapp_coroutineflow_hilt.core.data.source.local.LocalDataSource
import com.example.tourismapp_coroutineflow_hilt.core.data.source.remote.RemoteDataSource
import com.example.tourismapp_coroutineflow_hilt.core.data.source.remote.network.ApiResponse
import com.example.tourismapp_coroutineflow_hilt.core.data.source.remote.response.TourismResponse
import com.example.tourismapp_coroutineflow_hilt.core.domain.model.Tourism
import com.example.tourismapp_coroutineflow_hilt.core.domain.repository.ITourismRepository
import com.example.tourismapp_coroutineflow_hilt.core.utils.AppExecutors
import com.example.tourismapp_coroutineflow_hilt.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TourismRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): ITourismRepository {

    override fun getAllTourism(): Flow<Resource<List<Tourism>>> =
        object : NetworkBoundResource<List<Tourism>, List<TourismResponse>>() {
            override fun loadFromDB(): Flow<List<Tourism>> {
                return localDataSource.getAllTourism().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Tourism>?): Boolean =
                data.isNullOrEmpty()

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