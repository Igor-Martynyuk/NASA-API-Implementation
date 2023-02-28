package com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo.port

import com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo.dto.NearEarthObject
import java.util.Calendar

interface InPortNearEarthObjectList {
    suspend fun getNearEarthObjects(): List<NearEarthObject>
    suspend fun getNearEarthObjects(startDate: Calendar, endDate: Calendar): List<NearEarthObject>
}