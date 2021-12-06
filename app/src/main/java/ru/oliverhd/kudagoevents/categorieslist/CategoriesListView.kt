package ru.oliverhd.kudagoevents.categorieslist

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import ru.oliverhd.kudagoevents.model.EventCategory

@SingleState
interface CategoriesListView : MvpView {

    fun show(categoriesList: List<EventCategory>)
    fun error(e: Throwable)
}