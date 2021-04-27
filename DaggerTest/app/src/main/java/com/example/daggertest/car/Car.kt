package com.example.daggertest.car

import javax.inject.Inject

class Car  {

     private lateinit var engine: Engine
     private lateinit var wheel: Wheel

    @Inject constructor(engine: Engine, wheel: Wheel){
        this.engine=engine
        this.wheel=wheel
    }

    fun drive(){
        engine.startEngine()
        println("RUNNING CAR.....")
    }

    @Inject
    fun enableRemote(remote: Remote){
        remote.setListener(this)
    }
}