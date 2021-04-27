package com.example.daggerpracticemaster.car

import com.example.daggerpracticemaster.car.Engine
import javax.inject.Inject

class PetrolEngine : Engine {

    @Inject
    constructor(){

    }

    override fun startEngine() {
        println("Petrol engine started")
    }
}