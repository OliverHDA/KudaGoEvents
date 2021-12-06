package ru.oliverhd.kudagoevents.eventslist

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ru.oliverhd.kudagoevents.model.KudaGoEvent

object EventDiff : DiffUtil.ItemCallback<KudaGoEvent>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: KudaGoEvent, newItem: KudaGoEvent): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: KudaGoEvent, newItem: KudaGoEvent): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: KudaGoEvent, newItem: KudaGoEvent) = payload
}