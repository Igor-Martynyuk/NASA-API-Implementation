package com.devmartyniuk.nasa.api.implementation.layer.data.rest.apod.dto

import com.squareup.moshi.Json

@Suppress("SpellCheckingInspection")
data class ResponseAPOD(
    @field:Json(name = "copyright") val copyright: String,
    @field:Json(name = "data") val date: String,
    @field:Json(name = "explanation") val explanation: String,
    @field:Json(name = "hdurl") val HDUrl: String,
    @field:Json(name = "media_type") val mediaType: String,
    @field:Json(name = "service_version") val serviceVersion: String,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "url") val url: String
) {
    companion object {
        const val dateFormatRegex = "yyyy-MM-dd"
    }
}