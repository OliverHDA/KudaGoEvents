package ru.oliverhd.kudagoevents.datasource

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import ru.oliverhd.kudagoevents.model.KudaGoEvent
import ru.oliverhd.kudagoevents.storage.KudaGoStorage
import javax.inject.Inject

class CacheEventDataSourceImpl @Inject constructor(private val kudaGoStorage: KudaGoStorage) :
    CacheEventDataSource {

    override fun getEventById(eventID: Int): Maybe<KudaGoEvent> =
        kudaGoStorage.kudaGoEventDao().getEventById(eventID)

    override fun retain(event: KudaGoEvent)=
        kudaGoStorage.kudaGoEventDao()
            .retain(event)
}