package com.devmartyniuk.nasa.api.implementation.layer.data.getaway.web.neo.ws.dto

import com.devmartyniuk.nasa.api.implementation.layer.data.getaway.web.neo.ws.dto.nested.ResponseNeoCloseApproachData
import com.devmartyniuk.nasa.api.implementation.layer.data.getaway.web.neo.ws.dto.nested.ResponseNeoDiameter
import com.squareup.moshi.Json

data class ResponseNeoFeed(
    @field:Json(name = "links") val links: Map<String, String>,
    @field:Json(name = "elements_count") val elementsCount: Int,
    @field:Json(name = "near_earth_objects") val nearEarthObjects: Map<String, List<ResponseNeo>>
) {
    data class ResponseNeo(
        @field:Json(name = "links") val links: Map<String, String>,
        @field:Json(name = "id") val id: String,
        @field:Json(name = "neo_reference_id") val neoReferenceId: String,
        @field:Json(name = "name") val name: String,
        @field:Json(name = "nasa_jpl_url") val nasaJplUrl: String,
        @field:Json(name = "absolute_magnitude_h") val absoluteMagnitudeH: Double,
        @field:Json(name = "estimated_diameter") val estimatedDiameter: Map<String, ResponseNeoDiameter>,
        @field:Json(name = "is_potentially_hazardous_asteroid") val isPotentiallyHazardousAsteroid: Boolean,
        @field:Json(name = "close_approach_data") val closeApproachData: List<ResponseNeoCloseApproachData>,
        @field:Json(name = "is_sentry_object") val isSentryObject: Boolean
    )
}
