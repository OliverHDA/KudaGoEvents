package ru.oliverhd.kudagoevents.main

import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.oliverhd.kudagoevents.di.ApplicationComponent
import ru.oliverhd.kudagoevents.di.DaggerApplicationComponent

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()
                withRouter(cicerone.router)
                withNavigatorHolder(cicerone.getNavigatorHolder())
            }
            .build()
    }

    override fun applicationInjector(): AndroidInjector<App> =
        applicationComponent

    companion object {
        lateinit var instance: App
    }
}