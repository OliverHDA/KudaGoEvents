package ru.oliverhd.kudagoevents.repository

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventCategory(
    @SerializedName("id") val id: Int,
    @SerializedName("slug") val slug: String,
    @SerializedName("name") val name: String
) : Parcelable

fun getCategoriesList(): List<EventCategory> = listOf(
    EventCategory(1, "Выставки", "Выставки"),
    EventCategory(2, "Концерты", "Концерты"),
    EventCategory(3, "Фестивали", "Фестивали"),
    EventCategory(4, "Мастер классы", "Мастер классы"),
    EventCategory(5, "Театральные представления", "Театральные представления"),
    EventCategory(5, "Встречи", "Встречи")
)