package ru.oliverhd.kudagoevents.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.oliverhd.kudagoevents.categorieslist.CategoriesListFragment
import ru.oliverhd.kudagoevents.event.EventFragment
import ru.oliverhd.kudagoevents.eventslist.EventListFragment
import ru.oliverhd.kudagoevents.main.MainActivity

@Module
interface ContributesAndroidInjectorModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindCategoriesListFragment(): CategoriesListFragment

    @ContributesAndroidInjector
    fun bindEventListFragment(): EventListFragment

    @ContributesAndroidInjector
    fun bindEventFragment(): EventFragment
}