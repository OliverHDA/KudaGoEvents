package ru.oliverhd.kudagoevents.repository

import io.reactivex.Single

interface Repository {

    fun getLocalCategoriesList(): Single<List<EventCategory>>

    fun getRemoteCategoriesList(): Single<List<EventCategory>>
}