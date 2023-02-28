package com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo

import com.devmartyniuk.nasa.api.implementation.layer.domain.get.UseCase
import com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo.dto.NearEarthObject
import com.devmartyniuk.nasa.api.implementation.layer.domain.get.neo.port.InPortNearEarthObjectList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.transform

class CaseGetNearEarthObjectList(private val inPort: InPortNearEarthObjectList) :
    UseCase<Unit, NearEarthObject>() {

    override val producerScope: CoroutineScope get() = CoroutineScope(Dispatchers.IO)
    override val consumerScope: CoroutineScope get() = CoroutineScope(Dispatchers.Main.immediate)

    override suspend fun execute(args: Unit) = flow { emit(inPort.getNearEarthObjects()) }
        .transform { it.forEach { value -> emit(value) } }
        .flowOn(Dispatchers.IO)
}