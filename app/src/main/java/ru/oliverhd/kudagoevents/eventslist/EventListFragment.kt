package ru.oliverhd.kudagoevents.eventslist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import com.github.terrakok.cicerone.Router
import dagger.android.support.AndroidSupportInjection
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.oliverhd.kudagoevents.databinding.FragmentEventsListBinding
import ru.oliverhd.kudagoevents.model.EventCategory
import ru.oliverhd.kudagoevents.model.KudaGoEvent
import ru.oliverhd.kudagoevents.repository.Repository
import ru.oliverhd.kudagoevents.scheduler.Schedulers
import javax.inject.Inject

private const val ARG_CATEGORY = "category"

class EventListFragment : MvpAppCompatFragment(), EventListView, EventListAdapter.Delegate {

    private val category: EventCategory by lazy {
        arguments?.getParcelable<EventCategory>(ARG_CATEGORY) as EventCategory
    }

    @Inject
    lateinit var repository: Repository

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var schedulers: Schedulers

    private val eventListAdapter = EventListAdapter(delegate = this)

    private val presenter by moxyPresenter {
        EventListPresenter(
            repository,
            router,
            schedulers,
            category
        )
    }

    private var binding: FragmentEventsListBinding? = null

//    private val viewBinding: FragmentEventsListBinding by viewBinding()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentEventsListBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.eventsListRecyclerView?.adapter = eventListAdapter
    }

    override fun show(eventList: List<KudaGoEvent>) {
        eventListAdapter.submitList(eventList)
//        binding?.eventsListRecyclerView?.layoutManager = GridLayoutManager(context,2)
//            LinearLayoutManager(context)
    }

    override fun error(e: Throwable) {
        Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
    }

    override fun onEventClicked(event: KudaGoEvent) {
        presenter.showEventDetail(event)
    }

    companion object {

        fun newInstance(category: EventCategory) =
            EventListFragment().apply {
                arguments = bundleOf(ARG_CATEGORY to category)
            }
    }
}