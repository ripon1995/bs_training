package com.example.daggertest.car

import com.example.daggertest.car.Rim
import com.example.daggertest.car.Tires


class Wheel {

    private lateinit var rim: Rim
    private lateinit var tires: Tires

    constructor(rim: Rim, tires: Tires){
        this.rim=rim
        this.tires=tires
    }
}