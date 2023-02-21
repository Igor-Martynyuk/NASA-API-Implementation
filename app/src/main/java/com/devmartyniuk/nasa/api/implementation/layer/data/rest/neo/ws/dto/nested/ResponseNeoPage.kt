package com.devmartyniuk.nasa.api.implementation.layer.data.rest.neo.ws.dto.nested

import com.squareup.moshi.Json

data class ResponseNeoPage(
    @field:Json(name = "number") val number: Int,
    @field:Json(name = "size") val size: Int,
    @field:Json(name = "total_elements") val totalElements: Int,
    @field:Json(name = "total_pages") val totalPages: Int
)