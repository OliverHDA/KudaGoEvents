package ru.oliverhd.kudagoevents.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventImage(
    @SerializedName("image") val image_url: String?
):Parcelable