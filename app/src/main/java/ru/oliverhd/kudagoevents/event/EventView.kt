package ru.oliverhd.kudagoevents.event

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import ru.oliverhd.kudagoevents.model.KudaGoEvent
import ru.oliverhd.kudagoevents.model.Place

@SingleState
interface EventView:MvpView {

    fun showEvent(event: KudaGoEvent)
    fun showPlace(place: Place)
    fun error(e: Throwable)
}