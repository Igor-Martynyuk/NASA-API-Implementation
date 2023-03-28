package com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo

import com.devmartyniuk.nasa.api.implementation.layer.domain.get.UseCase
import com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo.dto.NearEarthObject
import com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo.port.InPortNearEarthObjectList
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.transform

class CaseGetNearEarthObjectList(private val inPort: InPortNearEarthObjectList) :
    UseCase<Unit, NearEarthObject> {

    override fun prepare(args: Unit) = flow { emit(inPort.getNearEarthObjects()) }
//        .transform { it.forEach { value -> emit(value) } }
        .transform { it.forEach { value -> emit(value) } }
}