package com.two.daggerdemo.car.di

import com.two.daggerdemo.car.CarFactory
import dagger.Component

@Component(modules = [EngineModule::class])
interface CarComponent {
    fun inject(carFactory: CarFactory)
}