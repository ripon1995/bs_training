package com.example.daggerpracticemaster.car

import javax.inject.Inject

class Car {

    private lateinit var engine: Engine
    private lateinit var wheels: Wheels

    @Inject
    constructor(engine: Engine, wheels: Wheels){
        this.engine=engine
        this.wheels=wheels
    }

    @Inject
    fun stopCar(){
        println("Car is stopping")
    }


    fun startCar(){
        engine.startEngine()
       println("Car is ready")
    }
}