package ru.oliverhd.kudagoevents.categorieslist

import com.github.terrakok.cicerone.androidx.FragmentScreen

object CategoriesListScreen {

    fun create() = FragmentScreen {
        CategoriesListFragment.newInstance()
    }
}