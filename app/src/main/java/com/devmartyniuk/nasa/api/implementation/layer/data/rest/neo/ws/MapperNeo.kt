package com.devmartyniuk.nasa.api.implementation.layer.data.rest.neo.ws

import com.devmartyniuk.nasa.api.implementation.layer.data.rest.neo.ws.dto.ResponseNeoBrowse
import com.devmartyniuk.nasa.api.implementation.layer.data.rest.neo.ws.dto.ResponseNeoFeed
import com.devmartyniuk.nasa.api.implementation.layer.data.rest.neo.ws.dto.ResponseNeoLookUp
import com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo.dto.NearEarthObject

class MapperNeo {

    fun mapBrowseResponse(response: ResponseNeoBrowse) = response
        .nearEarthObjects
        .map {
            NearEarthObject(
                it.id,
                it.name
            )
        }

    fun mapFeedResponse(response: ResponseNeoFeed) = response
        .nearEarthObjects
        .values
        .toList()
        .flatten()
        .map {
            NearEarthObject(
                it.id,
                it.name
            )
        }

    fun mapLookUpResponse(response: ResponseNeoLookUp) = response
        .run {
            NearEarthObject(
                id,
                name
            )
        }

}
