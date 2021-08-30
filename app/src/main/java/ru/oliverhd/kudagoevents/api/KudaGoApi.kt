package ru.oliverhd.kudagoevents.api

import io.reactivex.Single
import retrofit2.http.GET
import ru.oliverhd.kudagoevents.repository.EventCategory

interface KudaGoApi {

    @GET("event-categories/")
    fun getCategoriesList(): Single<List<EventCategory>>

    @GET("events/")
    fun getEventsByCategory(): Single<List<EventCategory>>

}