package com.devmartyniuk.nasa.api.implementation.layer.data.getaway.web.apod

import com.devmartyniuk.nasa.api.implementation.layer.data.getaway.web.apod.dto.ResponseAPOD
import com.devmartyniuk.nasa.api.implementation.layer.domain.get.pod.dto.PictureOfTheDay
import java.text.SimpleDateFormat
import java.util.*

class MapperAPOD {
    private val dateFormat = SimpleDateFormat(ResponseAPOD.dateFormatRegex, Locale.getDefault())

    private fun parseDate(input: String): Calendar? = dateFormat
        .parse(input)
        ?.let { Calendar.getInstance().apply { time = it } }

    fun mapResponse(from: ResponseAPOD) = from
        .run {
            PictureOfTheDay(
                copyright,
                parseDate(date),
                explanation,
                title,
                url
            )
        }
}