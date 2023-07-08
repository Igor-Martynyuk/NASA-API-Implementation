package com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo.port

import com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo.dto.NearEarthObject
import java.util.Calendar

interface InPortNearEarthObject {
    suspend fun getNearEarthObject(id: String): NearEarthObject
    suspend fun getNearEarthObjects(): List<NearEarthObject>
    suspend fun getNearEarthObjects(startDate: Calendar, endDate: Calendar): List<NearEarthObject>
}