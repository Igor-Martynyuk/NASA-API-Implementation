package com.devmartyniuk.nasa.api.implementation.layer.domain.get.pod.dto

import java.util.Calendar

data class PictureOfTheDay(
    val copyright: String,
    val date: Calendar?,
    val explanation: String,
    val title: String,
    val url: String
)