package ru.oliverhd.kudagoevents.datasource

import io.reactivex.Maybe
import io.reactivex.Single
import ru.oliverhd.kudagoevents.api.KudaGoApi
import ru.oliverhd.kudagoevents.model.EventCategory
import ru.oliverhd.kudagoevents.model.EventList
import ru.oliverhd.kudagoevents.model.KudaGoEvent
import ru.oliverhd.kudagoevents.model.Place
import javax.inject.Inject

const val FIELDS = "id,short_title,age_restriction,price,is_free,images"
const val PAGE_SIZE = 100
const val CITY_SPB = "spb"
const val TWO_WEEK: Long = 1209600

class RemoteDataSourceImpl @Inject constructor(private val kudaGoApi: KudaGoApi) :
    RemoteDataSource {

    override fun getEventCategoriesList(): Single<List<EventCategory>> =
        kudaGoApi.getCategoriesList()

    override fun getEventListByCategory(category: String): Single<EventList> =
        kudaGoApi.getEventsByCategory(
            FIELDS,
            PAGE_SIZE,
            CITY_SPB,
            System.currentTimeMillis() / 1000,
            System.currentTimeMillis() / 1000 + TWO_WEEK,
            category
        )

    override fun getEventById(eventID: Int): Maybe<KudaGoEvent> =
        kudaGoApi.getEventById(eventID, "text")

    override fun getPlaceById(placeId: Int): Single<Place> =
        kudaGoApi.getPlaceById(placeId)
}