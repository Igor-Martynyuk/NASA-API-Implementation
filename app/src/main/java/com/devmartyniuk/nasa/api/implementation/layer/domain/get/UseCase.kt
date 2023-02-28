package com.devmartyniuk.nasa.api.implementation.layer.domain.get

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

abstract class UseCase<A, R> {
    protected abstract val producerScope: CoroutineScope
    protected abstract val consumerScope: CoroutineScope

    abstract suspend fun execute(args: A): Flow<R>
}