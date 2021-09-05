package ru.oliverhd.kudagoevents.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.oliverhd.kudagoevents.model.KudaGoEvent

@TypeConverters(DataConverter::class)
@Database(exportSchema = false, entities = [KudaGoEvent::class], version = 1)
abstract class KudaGoStorage : RoomDatabase() {

    abstract fun kudaGoEventDao(): KudaGoEventDao
}