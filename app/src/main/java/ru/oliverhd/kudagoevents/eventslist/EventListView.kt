package ru.oliverhd.kudagoevents.eventslist

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import ru.oliverhd.kudagoevents.model.KudaGoEvent

@SingleState
interface EventListView : MvpView {

    fun show(eventList: List<KudaGoEvent>)
    fun error(e: Throwable)
}