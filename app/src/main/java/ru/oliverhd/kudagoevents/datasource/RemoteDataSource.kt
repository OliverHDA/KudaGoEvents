package ru.oliverhd.kudagoevents.datasource

import io.reactivex.Single
import ru.oliverhd.kudagoevents.repository.EventCategory

interface RemoteDataSource {

    fun getEventCategoriesList(): Single<List<EventCategory>>
}