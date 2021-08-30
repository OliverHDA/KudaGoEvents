package ru.oliverhd.kudagoevents.repository

import io.reactivex.Single
import ru.oliverhd.kudagoevents.datasource.RemoteDataSource
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) : Repository {

    override fun getLocalCategoriesList(): Single<List<EventCategory>> =
        Single.just(getCategoriesList())

    override fun getRemoteCategoriesList(): Single<List<EventCategory>> =
        remoteDataSource.getEventCategoriesList()

}