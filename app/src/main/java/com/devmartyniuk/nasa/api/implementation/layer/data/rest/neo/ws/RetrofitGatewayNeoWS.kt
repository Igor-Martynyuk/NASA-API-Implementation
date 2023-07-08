package com.devmartyniuk.nasa.api.implementation.layer.data.rest.neo.ws

import com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo.port.InPortNearEarthObject
import retrofit2.Retrofit
import java.text.SimpleDateFormat
import java.util.*

class RetrofitGatewayNeoWS(retrofit: Retrofit) : InPortNearEarthObject {
    private val retrofit = retrofit.create(ApiNeoWs::class.java)
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    private val neoMapper = MapperNeo()

    override suspend fun getNearEarthObjects() = retrofit
        .requestNeoBrowse()
        .run(neoMapper::mapBrowseResponse)

    override suspend fun getNearEarthObjects(startDate: Calendar, endDate: Calendar) = retrofit
        .requestNeoFeed(dateFormat.format(startDate.time), dateFormat.format(endDate.time))
        .run(neoMapper::mapFeedResponse)

    override suspend fun getNearEarthObject(id: String) = retrofit
        .requestLookUp(id)
        .run(neoMapper::mapLookUpResponse)
}
