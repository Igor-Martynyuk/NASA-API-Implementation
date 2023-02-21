package com.devmartyniuk.nasa.api.implementation.layer.data.rest.neo.ws.dto.nested

import com.squareup.moshi.Json

data class ResponseNeoDiameter(
    @field:Json(name = "estimated_diameter_min") val estimatedDiameterMin: Double,
    @field:Json(name = "estimated_diameter_max") val estimatedDiameterMax: Double
)
