package com.example.daggertest.car

import com.example.daggertest.car.Car
import javax.inject.Inject

class Remote {

    @Inject
    constructor()

    public fun setListener(car: Car){
        println("Remote connected")
    }
}