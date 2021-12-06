package ru.oliverhd.kudagoevents.di.modules

import dagger.Binds
import dagger.Module
import ru.oliverhd.kudagoevents.datasource.CacheEventDataSource
import ru.oliverhd.kudagoevents.datasource.CacheEventDataSourceImpl
import ru.oliverhd.kudagoevents.datasource.RemoteDataSource
import ru.oliverhd.kudagoevents.datasource.RemoteDataSourceImpl
import javax.inject.Singleton

@Module
interface DataSourceModule {

    @Singleton
    @Binds
    fun bindRemoteDataSource(dataSource: RemoteDataSourceImpl): RemoteDataSource

    @Singleton
    @Binds
    fun bindCacheEventDataSource(dataSource: CacheEventDataSourceImpl): CacheEventDataSource
}