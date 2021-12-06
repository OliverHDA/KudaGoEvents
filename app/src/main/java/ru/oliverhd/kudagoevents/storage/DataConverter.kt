package ru.oliverhd.kudagoevents.storage

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.oliverhd.kudagoevents.model.EventImage
import ru.oliverhd.kudagoevents.model.Place
import java.lang.reflect.Type

class DataConverter {

    @TypeConverter
    fun fromPlaceToString(place: Place): String {
        val gson = Gson()
        val type: Type = object : TypeToken<Place>() {}.type
        return gson.toJson(place, type)
    }

    @TypeConverter
    fun toPlace(placeString: String): Place {
        val gson = Gson()
        val type: Type = object : TypeToken<Place>() {}.type
        return gson.fromJson(placeString, type)
    }

    @TypeConverter
    fun fromImagesString(images: List<EventImage>): String {
        val gson = Gson()
        val type: Type = object : TypeToken<List<EventImage>>() {}.type
        return gson.toJson(images, type)
    }

    @TypeConverter
    fun toImages(imagesString: String): List<EventImage> {
        val gson = Gson()
        val type: Type = object : TypeToken<List<EventImage>>() {}.type
        return gson.fromJson(imagesString, type)
    }
}