package ru.oliverhd.kudagoevents.categorieslist

import com.github.terrakok.cicerone.Router
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import moxy.MvpPresenter
import ru.oliverhd.kudagoevents.eventslist.EventsListScreen
import ru.oliverhd.kudagoevents.repository.EventCategory
import ru.oliverhd.kudagoevents.repository.Repository

class CategoriesListPresenter(
    private val repository: Repository,
    private val router: Router
) : MvpPresenter<CategoriesListView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        disposables.add(
            repository
                .getRemoteCategoriesList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
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