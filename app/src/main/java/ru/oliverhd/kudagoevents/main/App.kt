package ru.oliverhd.kudagoevents.main

import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.oliverhd.kudagoevents.di.ApplicationComponent
import ru.oliverhd.kudagoevents.di.DaggerApplicationComponent
import ru.oliverhd.kudagoevents.scheduler.DefaultSchedulers

class App : DaggerApplication() {

    private val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()
                withRouter(cicerone.router)
                withNavigatorHolder(cicerone.getNavigatorHolder())
                withSchedulers(DefaultSchedulers())
            }
            .build()
    }

    override fun applicationInjector(): AndroidInjector<App> =
        applicationComponent
}