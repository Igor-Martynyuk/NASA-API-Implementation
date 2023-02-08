package com.devmartyniuk.nasa.api.implementation.layer.data.getaway.web.apod

import com.devmartyniuk.nasa.api.implementation.layer.data.getaway.web.apod.dto.ResponseAPOD
import retrofit2.http.GET

@Suppress("SpellCheckingInspection")
interface ApiAPOD {
    @GET("planetary/apod")
    suspend fun loadPictureOfTheDayAsync(): ResponseAPOD
}