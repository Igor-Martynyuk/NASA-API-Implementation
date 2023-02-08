package com.devmartyniuk.nasa.api.implementation.layer.data.getaway.web.neo.ws.dto.nested

import com.squareup.moshi.Json

data class ResponseNeoOrbitClass(
    @field:Json(name = "orbit_class_type") val orbitClassType: String,
    @field:Json(name = "orbit_class_description") val orbitClassDescription: String,
    @field:Json(name = "orbit_class_range") val orbitClassRange: String
)
