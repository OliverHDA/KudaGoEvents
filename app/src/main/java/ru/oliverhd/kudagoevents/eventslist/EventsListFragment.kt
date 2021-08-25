package ru.oliverhd.kudagoevents.eventslist

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.oliverhd.kudagoevents.databinding.FragmentEventsListBinding
import ru.oliverhd.kudagoevents.repository.EventCategory

private const val ARG_CATEGORY = "category"

class EventListFragment : Fragment() {

    private val category: EventCategory by lazy {
        arguments?.getParcelable<EventCategory>(ARG_CATEGORY) as EventCategory
    }

    private val viewBinding: FragmentEventsListBinding by viewBinding()

    companion object {

        fun newInstance(category: EventCategory) =
            EventListFragment().apply {
                arguments = bundleOf(ARG_CATEGORY to category)
            }
    }
}