package com.two.daggerdemo.car

import android.util.Log
import javax.inject.Inject

class Car @Inject constructor(private val engine: Engine) {
    fun start(){
        engine.start()
    }
}

interface Engine {
    fun start()
}

class GasEngine @Inject constructor() : Engine {
    override fun start() {
        Log.d("####","Gas engine")
    }
}

class PetrolEngine @Inject constructor() : Engine {
    override fun start() {
        Log.d("####","Petrol engine")
    }
}

class ElectricEngine @Inject constructor() : Engine {
    override fun start() {
        Log.d("####","Electric engine")
    }
}
