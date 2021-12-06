package ru.oliverhd.kudagoevents.categorieslist

import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.oliverhd.kudagoevents.eventslist.EventsListScreen
import ru.oliverhd.kudagoevents.model.EventCategory
import ru.oliverhd.kudagoevents.repository.Repository
import ru.oliverhd.kudagoevents.scheduler.Schedulers

class CategoriesListPresenter(
    private val repository: Repository,
    private val router: Router,
    private val schedulers: Schedulers
) : MvpPresenter<CategoriesListView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        disposables.add(
            repository
                .getRemoteCategoriesList()
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(viewState::show, viewState::error)
        )
    }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }

    fun showEventsList(category: EventCategory) {
        router.navigateTo(EventsListScreen(category).create())
    }
}