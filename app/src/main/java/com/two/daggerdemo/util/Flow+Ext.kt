package com.two.daggerdemo.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

fun <T> flowSingle(action: suspend () -> T): Flow<T> {
    return flow { emit(action.invoke()) }.flowOn(Dispatchers.IO)
}