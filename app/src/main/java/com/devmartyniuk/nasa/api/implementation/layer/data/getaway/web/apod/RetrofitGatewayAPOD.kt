package com.devmartyniuk.nasa.api.implementation.layer.data.getaway.web.apod

import com.devmartyniuk.nasa.api.implementation.layer.domain.get.pod.dto.PictureOfTheDay
import com.devmartyniuk.nasa.api.implementation.layer.domain.get.pod.port.InPortPictureOfDay
import retrofit2.Retrofit

class RetrofitGatewayAPOD(retrofit: Retrofit, private val mapper: MapperAPOD) : InPortPictureOfDay {
    private val retrofit = retrofit.create(ApiAPOD::class.java)

    override suspend fun getPictureOfTheDay(): PictureOfTheDay = retrofit
        .loadPictureOfTheDayAsync()
        .run(mapper::mapResponse)
}