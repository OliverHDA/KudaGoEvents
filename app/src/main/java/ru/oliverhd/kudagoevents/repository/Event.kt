package ru.oliverhd.kudagoevents.repository

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    @SerializedName("id") val id: Int,
    @SerializedName("publication_date") val publication_date: String,
    @SerializedName("dates") val dates: String,
    @SerializedName("title") val title: String,
    @SerializedName("place") val place: String,
    @SerializedName("description") val description: String,
    @SerializedName("body_text") val body_text: String,
    @SerializedName("categories") val categories: String,
    @SerializedName("age_restriction") val age_restriction: String,
    @SerializedName("price") val price: String,
    @SerializedName("images") val images: String
) : Parcelable
