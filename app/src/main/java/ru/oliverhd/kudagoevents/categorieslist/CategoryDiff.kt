package ru.oliverhd.kudagoevents.categorieslist

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ru.oliverhd.kudagoevents.model.EventCategory

object CategoryDiff : DiffUtil.ItemCallback<EventCategory>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: EventCategory, newItem: EventCategory): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: EventCategory, newItem: EventCategory): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: EventCategory, newItem: EventCategory) = payload

}