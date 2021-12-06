package ru.oliverhd.kudagoevents.eventslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import ru.oliverhd.kudagoevents.R
import ru.oliverhd.kudagoevents.databinding.EventListItemBinding
import ru.oliverhd.kudagoevents.model.KudaGoEvent

class EventListAdapter(
    private val delegate: Delegate?
) : ListAdapter<KudaGoEvent, EventListAdapter.EventListViewHolder>(EventDiff) {

    interface Delegate {
        fun onEventClicked(event: KudaGoEvent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventListViewHolder =
        EventListViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.event_list_item, parent, false)
        )

    override fun onBindViewHolder(holder: EventListViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)

    class EventListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val viewBinding: EventListItemBinding by viewBinding()

        fun bind(event: KudaGoEvent, delegate: Delegate?) {
            with(viewBinding) {
                eventListItemTittle.text = event.short_title
                if(!event.isFree) eventListItemIsFree.visibility = View.GONE
                eventListCard.setOnClickListener {
                    delegate?.onEventClicked(event)
                }
                Glide
                    .with(viewBinding.eventListItemImageView)
                    .load(event.images[0].image_url)
                    .into(viewBinding.eventListItemImageView)
            }
        }
    }
}