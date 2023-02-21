package com.devmartyniuk.nasa.api.implementation.layer.data.rest.neo.ws

import com.devmartyniuk.nasa.api.implementation.layer.data.rest.neo.ws.dto.ResponseNeoBrowse
import com.devmartyniuk.nasa.api.implementation.layer.data.rest.neo.ws.dto.ResponseNeoFeed
import com.devmartyniuk.nasa.api.implementation.layer.data.rest.neo.ws.dto.ResponseNeoLookUp
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiNeoWs {
    @GET("neo/rest/v1/neo/browse")
    suspend fun requestNeoBrowse(): ResponseNeoBrowse

    @GET("neo/rest/v1/feed")
    suspend fun requestNeoFeed(
        @Query(value = "start_date") startDate: String,
        @Query(value = "end_date") endDate: String
    ): ResponseNeoFeed

    @GET("neo/rest/v1/neo/{id}")
    suspend fun requestLookUp(@Path("id") id: String): ResponseNeoLookUp
}