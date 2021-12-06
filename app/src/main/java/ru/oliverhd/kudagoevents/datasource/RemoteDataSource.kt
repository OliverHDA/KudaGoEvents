package ru.oliverhd.kudagoevents.datasource

import io.reactivex.Maybe
import io.reactivex.Single
import ru.oliverhd.kudagoevents.model.EventCategory
import ru.oliverhd.kudagoevents.model.EventList
import ru.oliverhd.kudagoevents.model.KudaGoEvent
import ru.oliverhd.kudagoevents.model.Place

interface RemoteDataSource {

    fun getEventCategoriesList(): Single<List<EventCategory>>

    fun getEventListByCategory(category: String): Single<EventList>

    fun getEventById(eventID: Int): Maybe<KudaGoEvent>

    fun getPlaceById(placeId: Int): Single<Place>
}