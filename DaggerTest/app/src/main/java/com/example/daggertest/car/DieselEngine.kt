package com.example.daggertest.car

import javax.inject.Inject

class DieselEngine: Engine {

    @Inject
    constructor(){

    }

    override fun startEngine() {
        println("Diesel engine started")
    }
}