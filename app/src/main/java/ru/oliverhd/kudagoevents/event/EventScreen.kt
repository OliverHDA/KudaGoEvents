package ru.oliverhd.kudagoevents.event

import com.github.terrakok.cicerone.androidx.FragmentScreen

class EventScreen(private val eventId: Int) {

    fun create(): FragmentScreen = FragmentScreen { EventFragment.newInstance(eventId) }
}