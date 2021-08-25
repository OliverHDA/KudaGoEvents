package ru.oliverhd.kudagoevents.repository

import io.reactivex.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor() : Repository {

    override fun getLocalCategoriesList(): Single<List<EventCategory>> =
        Single.just(getCategoriesList())
}