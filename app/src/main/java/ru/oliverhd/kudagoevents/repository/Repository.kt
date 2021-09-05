package ru.oliverhd.kudagoevents.repository

import io.reactivex.Maybe
import io.reactivex.Single
import ru.oliverhd.kudagoevents.model.EventCategory
import ru.oliverhd.kudagoevents.model.EventList
import ru.oliverhd.kudagoevents.model.KudaGoEvent
import ru.oliverhd.kudagoevents.model.Place

interface Repository {

    fun getLocalCategoriesList(): Single<List<EventCategory>>

    fun getRemoteCategoriesList(): Single<List<EventCategory>>

    fun getEventListByCategory(category: String): Single<EventList>

    fun getEventById(eventID: Int): Maybe<KudaGoEvent>

    fun getPlaceById(placeId: Int): Single<Place>
}