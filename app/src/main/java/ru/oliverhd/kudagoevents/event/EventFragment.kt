package ru.oliverhd.kudagoevents.event

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
import ru.oliverhd.kudagoevents.R
import ru.oliverhd.kudagoevents.databinding.FragmentEventBinding
import ru.oliverhd.kudagoevents.model.KudaGoEvent
import ru.oliverhd.kudagoevents.model.Place
import ru.oliverhd.kudagoevents.repository.Repository
import ru.oliverhd.kudagoevents.scheduler.Schedulers
import javax.inject.Inject

private const val ARG_EVENT_ID = "eventID"

class EventFragment : MvpAppCompatFragment(), EventView {

    private val eventID by lazy {
        arguments?.getInt(ARG_EVENT_ID) as Int
    }

    @Inject
    lateinit var repository: Repository

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var schedulers: Schedulers

//    private val viewBinding: FragmentEventBinding by viewBinding()

    private var binding: FragmentEventBinding? = null

    private val eventImageAdapter = EventImageAdapter()

    private val presenter by moxyPresenter {
        EventPresenter(
            repository,
            router,
            schedulers,
            eventID
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentEventBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.eventImageRecyclerView?.adapter = eventImageAdapter
    }

    override fun showEvent(event: KudaGoEvent) {
        eventImageAdapter.submitList(event.images)
        binding?.eventTitle?.text = event.title
        if (event.isFree) {
            binding?.eventPrice?.text = getString(R.string.free)
        } else {
            binding?.eventPrice?.text = event.price
        }
        binding?.eventDescription?.text = event.description
    }

    override fun showPlace(place: Place) {
        binding?.eventPlace?.text = place.title
        binding?.eventAddress?.text = place.address
    }

    override fun error(e: Throwable) {
        Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
    }

    companion object {

        fun newInstance(eventId: Int) =
            EventFragment().apply {
                arguments = bundleOf(ARG_EVENT_ID to eventId)
            }
    }
}