package ru.oliverhd.kudagoevents.eventslist

import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.oliverhd.kudagoevents.event.EventScreen
import ru.oliverhd.kudagoevents.model.EventCategory
import ru.oliverhd.kudagoevents.model.KudaGoEvent
import ru.oliverhd.kudagoevents.repository.Repository
import ru.oliverhd.kudagoevents.scheduler.Schedulers

class EventListPresenter(
    private val repository: Repository,
    private val router: Router,
    private val schedulers: Schedulers,
    private val category: EventCategory
) : MvpPresenter<EventListView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        disposables.add(
            repository
                .getEventListByCategory(category.slug)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe({ viewState.show(it.results) }, viewState::error)
        )
    }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }

    fun showEventDetail(event: KudaGoEvent) {
        router.navigateTo(EventScreen(event.id).create())
    }
}