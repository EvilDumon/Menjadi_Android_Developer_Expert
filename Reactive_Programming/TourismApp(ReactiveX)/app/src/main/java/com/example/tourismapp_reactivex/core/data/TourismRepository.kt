package com.example.tourismapp_reactivex.core.data

import com.example.tourismapp_reactivex.core.data.source.local.LocalDataSource
import com.example.tourismapp_reactivex.core.data.source.remote.RemoteDataSource
import com.example.tourismapp_reactivex.core.data.source.remote.network.ApiResponse
import com.example.tourismapp_reactivex.core.data.source.remote.response.TourismResponse
import com.example.tourismapp_reactivex.core.domain.model.Tourism
import com.example.tourismapp_reactivex.core.domain.repository.ITourismRepository
import com.example.tourismapp_reactivex.core.utils.AppExecutors
import com.example.tourismapp_reactivex.core.utils.DataMapper
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TourismRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): ITourismRepository {

    companion object {
        @Volatile
        private var instance: TourismRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): TourismRepository =
            instance ?: synchronized(this) {
                instance ?: TourismRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllTourism(): Flowable<Resource<List<Tourism>>> =
        object : NetworkBoundResource<List<Tourism>, List<TourismResponse>>() {
            override fun loadFromDB(): Flowable<List<Tourism>> {
                return localDataSource.getAllTourism().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Tourism>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): Flowable<ApiResponse<List<TourismResponse>>> =
                remoteDataSource.getAllTourism()

            override fun saveCallResult(data: List<TourismResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()

    override fun getFavoriteTourism(): Flowable<List<Tourism>> {
        return localDataSource.getFavoriteTourism().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
    }
}