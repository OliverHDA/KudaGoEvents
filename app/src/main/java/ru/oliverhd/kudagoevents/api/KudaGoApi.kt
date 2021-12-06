package ru.oliverhd.kudagoevents.api

import io.reactivex.Maybe
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.oliverhd.kudagoevents.model.EventCategory
import ru.oliverhd.kudagoevents.model.EventList
import ru.oliverhd.kudagoevents.model.KudaGoEvent
import ru.oliverhd.kudagoevents.model.Place

interface KudaGoApi {

    @GET("event-categories/")
    fun getCategoriesList(): Single<List<EventCategory>>

    @GET("events/")
    fun getEventsByCategory(
        @Query("fields") fields: String,
        @Query("page_size") page_size: Int,
        @Query("location") location: String,
        @Query("actual_since") actual_since: Long,
        @Query("actual_until") actual_until: Long,
        @Query("categories") categories: String
    ): Single<EventList>

    @GET("events/{event_id}/")
    fun getEventById(
        @Path("event_id") event_id: Int,
        @Query("text_format") text_format: String
    ): Maybe<KudaGoEvent>

    @GET("places/{place_id}/")
    fun getPlaceById(
        @Path("place_id") place_id: Int
    ): Single<Place>
}