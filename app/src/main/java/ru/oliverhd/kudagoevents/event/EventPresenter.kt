package ru.oliverhd.kudagoevents.event

import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.oliverhd.kudagoevents.model.KudaGoEvent
import ru.oliverhd.kudagoevents.repository.Repository
import ru.oliverhd.kudagoevents.scheduler.Schedulers

class EventPresenter(
    private val repository: Repository,
    private val router: Router,
    private val schedulers: Schedulers,
    private val eventID: Int
) : MvpPresenter<EventView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        disposables.add(
            repository
                .getEventById(eventID)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(::onEventSuccess, viewState::error)
        )
    }

    private fun onEventSuccess(event: KudaGoEvent) {
        viewState.showEvent(event)
        if (event.place != null) disposables.add(
            repository
                .getPlaceById(event.place.id)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(viewState::showPlace, viewState::error)
        )
    }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }
}