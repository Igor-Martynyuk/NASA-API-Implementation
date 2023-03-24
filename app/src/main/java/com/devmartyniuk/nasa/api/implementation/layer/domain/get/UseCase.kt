package com.devmartyniuk.nasa.api.implementation.layer.domain.get

import kotlinx.coroutines.flow.Flow

interface UseCase<A, R> {
    fun prepare(args: A): Flow<R>
}