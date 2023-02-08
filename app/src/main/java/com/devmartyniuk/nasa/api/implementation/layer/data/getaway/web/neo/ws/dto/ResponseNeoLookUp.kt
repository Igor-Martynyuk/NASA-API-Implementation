package com.devmartyniuk.nasa.api.implementation.layer.data.getaway.web.neo.ws.dto

import com.devmartyniuk.nasa.api.implementation.layer.data.getaway.web.neo.ws.dto.nested.ResponseNeoCloseApproachData
import com.devmartyniuk.nasa.api.implementation.layer.data.getaway.web.neo.ws.dto.nested.ResponseNeoDiameter
import com.devmartyniuk.nasa.api.implementation.layer.data.getaway.web.neo.ws.dto.nested.ResponseNeoOrbitalData
import com.squareup.moshi.Json

data class ResponseNeoLookUp(
    @field:Json(name = "links") val links: Map<String, String>,
    @field:Json(name = "id") val id: String,
    @field:Json(name = "neo_reference_id") val neoReferenceId: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "designation") val designation: String,
    @field:Json(name = "nasa_jpl_url") val nasaJplUrl: String,
    @field:Json(name = "absolute_magnitude_h") val absoluteMagnitudeH: Double,
    @field:Json(name = "estimated_diameter") val estimatedDiameter: Map<String, ResponseNeoDiameter>,
    @field:Json(name = "is_potentially_hazardous_asteroid") val isPotentiallyHazardousAsteroid: Boolean,
    @field:Json(name = "close_approach_data") val closeApproachData: List<ResponseNeoCloseApproachData>,
    @field:Json(name = "orbital_data") val orbitalData: ResponseNeoOrbitalData,
    @field:Json(name = "is_sentry_object") val isSentryObject: Boolean
)
