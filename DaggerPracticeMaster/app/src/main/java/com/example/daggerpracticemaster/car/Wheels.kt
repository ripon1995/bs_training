package com.example.daggerpracticemaster.car

class Wheels {

    private lateinit var wheelRim: WheelRim
    private lateinit var wheelTyre: WheelTyre

    constructor(wheelRim: WheelRim, wheelTyre: WheelTyre){
        this.wheelRim=wheelRim
        this.wheelTyre=wheelTyre

      println("Wheel is ready")
    }

}