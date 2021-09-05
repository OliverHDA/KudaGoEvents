package ru.oliverhd.kudagoevents.di.modules

import dagger.Binds
import dagger.Module
import ru.oliverhd.kudagoevents.repository.Repository
import ru.oliverhd.kudagoevents.repository.RepositoryImpl
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindRepository(repository: RepositoryImpl): Repository
}