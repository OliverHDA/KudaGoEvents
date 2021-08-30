package ru.oliverhd.kudagoevents.datasource

import io.reactivex.Single
import ru.oliverhd.kudagoevents.api.KudaGoApi
import ru.oliverhd.kudagoevents.repository.EventCategory
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val kudaGoApi: KudaGoApi): RemoteDataSource {

    override fun getEventCategoriesList(): Single<List<EventCategory>> =
        kudaGoApi.getCategoriesList()

}