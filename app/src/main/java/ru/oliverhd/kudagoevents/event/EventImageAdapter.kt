package ru.oliverhd.kudagoevents.event

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import ru.oliverhd.kudagoevents.R
import ru.oliverhd.kudagoevents.databinding.EventImageItemBinding
import ru.oliverhd.kudagoevents.model.EventImage

class EventImageAdapter(
) : ListAdapter<EventImage, EventImageAdapter.EventImageViewHolder>(ImageDiff) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventImageViewHolder =
        EventImageViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.event_image_item, parent, false)
        )

    override fun onBindViewHolder(holder: EventImageViewHolder, position: Int) =
        holder.bind(getItem(position))

    class EventImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val viewBinding: EventImageItemBinding by viewBinding()

        fun bind(image: EventImage) {
            with(viewBinding) {
                eventImage

                Glide
                    .with(viewBinding.eventImage)
                    .load(image.image_url)
                    .into(viewBinding.eventImage)
            }
        }
    }
}