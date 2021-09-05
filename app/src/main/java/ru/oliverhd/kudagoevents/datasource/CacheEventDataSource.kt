package ru.oliverhd.kudagoevents.datasource

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import ru.oliverhd.kudagoevents.model.KudaGoEvent

interface CacheEventDataSource {

    fun getEventById(eventID: Int): Maybe<KudaGoEvent>
    fun retain(event: KudaGoEvent)
}