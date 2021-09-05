package ru.oliverhd.kudagoevents.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.oliverhd.kudagoevents.storage.KudaGoStorage

@Module
class KudaGoStorageModule {

    @Provides
    fun provideGitHubMemoryStorage(context: Context) =
        Room.inMemoryDatabaseBuilder(context, KudaGoStorage::class.java)
            .build()
}