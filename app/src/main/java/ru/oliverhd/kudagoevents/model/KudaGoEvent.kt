package ru.oliverhd.kudagoevents.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "kudago_events")
@Parcelize
data class KudaGoEvent(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @ColumnInfo(name = "title")
    @SerializedName("title") val title: String,
    @ColumnInfo(name = "shortTitle")
    @SerializedName("short_title") val short_title: String,
    @ColumnInfo(name = "slug")
    @SerializedName("slug") val slug: String,
    @ColumnInfo(name = "place")
    @SerializedName("place") val place: Place?,
    @ColumnInfo(name = "images")
    @SerializedName("images") val images: List<EventImage>,
    @ColumnInfo(name = "description")
    @SerializedName("description") val description: String,
    @ColumnInfo(name = "bodyText")
    @SerializedName("body_text") val body_text: String,
    @ColumnInfo(name = "ageRestriction")
    @SerializedName("age_restriction") val age_restriction: String,
    @ColumnInfo(name = "price")
    @SerializedName("price") val price: String,
    @ColumnInfo(name = "isFree")
    @SerializedName("is_free") val isFree: Boolean
) : Parcelable
