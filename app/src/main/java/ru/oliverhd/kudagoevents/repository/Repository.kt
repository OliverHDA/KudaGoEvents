package ru.oliverhd.kudagoevents.repository

import io.reactivex.Single

interface Repository {

    fun getLocalCategoriesList(): Single<List<EventCategory>>
}