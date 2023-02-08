package com.devmartyniuk.nasa.api.implementation.layer.domain.get.pod.port

import com.devmartyniuk.nasa.api.implementation.layer.domain.get.pod.dto.PictureOfTheDay

interface InPortPictureOfDay {
    suspend fun getPictureOfTheDay(): PictureOfTheDay
}