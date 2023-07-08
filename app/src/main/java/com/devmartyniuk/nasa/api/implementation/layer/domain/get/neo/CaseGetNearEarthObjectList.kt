package com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo

import com.devmartyniuk.nasa.api.implementation.layer.domain.get.UseCase
import com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo.dto.NearEarthObject
import com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo.port.InPortNearEarthObject
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.transform

class CaseGetNearEarthObjectList(private val inPort: InPortNearEarthObject) :
    UseCase<Unit, NearEarthObject> {

    override fun prepare(args: Unit) = flow { emit(inPort.getNearEarthObjects()) }
        .transform { it.forEach { value -> emit(value) } }
}