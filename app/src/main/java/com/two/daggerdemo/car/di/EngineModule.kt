package com.two.daggerdemo.car.di

import com.two.daggerdemo.car.Engine
import dagger.Module
import dagger.Provides

@Module
class EngineModule(private val engine: Engine) {
    @Provides
    fun engine(): Engine {
        return engine
    }
} //We can now dynamically change the engine, but we just created the engine somewhere else