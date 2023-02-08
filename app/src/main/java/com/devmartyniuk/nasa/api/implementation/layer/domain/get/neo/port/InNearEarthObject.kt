package com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo.port

import com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo.dto.NearEarthObject

interface InNearEarthObject {
    suspend fun getNearEarthObject(id: String): NearEarthObject
}