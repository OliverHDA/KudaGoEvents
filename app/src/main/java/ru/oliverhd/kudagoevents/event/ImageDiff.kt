package ru.oliverhd.kudagoevents.event

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ru.oliverhd.kudagoevents.model.EventImage

object ImageDiff : DiffUtil.ItemCallback<EventImage>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: EventImage, newItem: EventImage): Boolean {
        return oldItem.image_url == newItem.image_url
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: EventImage, newItem: EventImage): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: EventImage, newItem: EventImage) = payload
}