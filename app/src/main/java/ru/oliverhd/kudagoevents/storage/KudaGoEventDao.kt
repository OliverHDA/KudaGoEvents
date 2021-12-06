package ru.oliverhd.kudagoevents.storage

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import ru.oliverhd.kudagoevents.model.KudaGoEvent

@Dao
interface KudaGoEventDao {

    @Query("SELECT * FROM kudago_events WHERE id LIKE :eventId LIMIT 1")
    fun getEventById(eventId: Int): Maybe<KudaGoEvent>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(event: KudaGoEvent)
}