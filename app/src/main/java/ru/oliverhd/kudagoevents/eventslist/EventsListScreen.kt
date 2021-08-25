package ru.oliverhd.kudagoevents.eventslist

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.oliverhd.kudagoevents.repository.EventCategory

class EventsListScreen(private val category: EventCategory) {

    fun create() = FragmentScreen { EventListFragment.newInstance(category) }
}