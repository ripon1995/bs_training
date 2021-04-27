package com.example.daggertest.car

import com.example.daggertest.car.Engine
import javax.inject.Inject

class PetrolEngine : Engine {

    @Inject
    constructor(){

    }

    override fun startEngine() {
        println("Petrol engine Started")
    }
}