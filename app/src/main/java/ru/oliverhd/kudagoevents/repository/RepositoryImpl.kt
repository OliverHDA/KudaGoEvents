package ru.oliverhd.kudagoevents.repository

import io.reactivex.Maybe
import io.reactivex.Single
import ru.oliverhd.kudagoevents.datasource.CacheEventDataSource
import ru.oliverhd.kudagoevents.datasource.RemoteDataSource
import ru.oliverhd.kudagoevents.model.*
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val cacheEventDataSource: CacheEventDataSource
) : Repository {

    override fun getLocalCategoriesList(): Single<List<EventCategory>> =
        Single.just(getCategoriesList())

    override fun getRemoteCategoriesList(): Single<List<EventCategory>> =
        remoteDataSource.getEventCategoriesList()

    override fun getEventListByCategory(category: String): Single<EventList> =
        remoteDataSource.getEventListByCategory(category)

    override fun getEventById(eventID: Int): Maybe<KudaGoEvent> =
        cacheEventDataSource
            .getEventById(eventID)
            .switchIfEmpty(
                remoteDataSource
                    .getEventById(eventID)
                    .doAfterSuccess {
                        cacheEventDataSource
                            .retain(it)
                    }
            )

    override fun getPlaceById(placeId: Int): Single<Place> =
        remoteDataSource.getPlaceById(placeId)

}