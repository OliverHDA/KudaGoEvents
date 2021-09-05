package ru.oliverhd.kudagoevents.scheduler

import io.reactivex.Scheduler

interface Schedulers {

    fun background(): Scheduler
    fun main(): Scheduler
}