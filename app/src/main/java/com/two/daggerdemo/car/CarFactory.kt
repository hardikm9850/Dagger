package com.two.daggerdemo.car

import com.two.daggerdemo.car.di.DaggerCarComponent
import com.two.daggerdemo.car.di.EngineModule
import javax.inject.Inject

class CarFactory {

    @Inject
    lateinit var car: Car

    fun createElectricCar() {
        injectDependency(ElectricEngine())
        car.start()
    }

    fun createGasCar() {
        injectDependency(GasEngine())
        car.start()
    }

    fun createPetrolCar() {
        injectDependency(PetrolEngine())
        car.start()
    }

    private fun injectDependency(engine: Engine) {
        val daggerCarComponent =
            DaggerCarComponent
                .builder()
                .engineModule(EngineModule(engine))
                .build()
        daggerCarComponent.inject(this)
    }
}