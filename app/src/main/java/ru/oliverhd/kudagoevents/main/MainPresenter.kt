package ru.oliverhd.kudagoevents.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.oliverhd.kudagoevents.categorieslist.CategoriesListScreen

class MainPresenter(
    private val router: Router
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(CategoriesListScreen.create())
    }

    fun back() = router.exit()
}