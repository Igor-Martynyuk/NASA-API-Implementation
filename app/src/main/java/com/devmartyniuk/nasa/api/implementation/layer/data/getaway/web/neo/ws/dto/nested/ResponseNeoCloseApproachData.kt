package com.devmartyniuk.nasa.api.implementation.layer.data.getaway.web.neo.ws.dto.nested

import com.squareup.moshi.Json

data class ResponseNeoCloseApproachData(
    @field:Json(name = "close_approach_date") val closeApproachDate: String,
    @field:Json(name = "close_approach_date_full") val closeApproachDateFull: String,
    @field:Json(name = "epoch_date_close_approach") val epochDateCloseApproach: String,
    @field:Json(name = "relative_velocity") val relativeVelocity: Map<String, String>,
    @field:Json(name = "miss_distance") val missDistance: Map<String, String>,
    @field:Json(name = "orbiting_body") val orbitingBody: String
)
