package ru.oliverhd.kudagoevents.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Place(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String?,
    @SerializedName("address") val address: String?,
    @SerializedName("timetable") val timetable: String?,
    @SerializedName("phone") val phone: String?
) : Parcelable
