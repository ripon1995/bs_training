package com.example.daggerpracticemaster.dagger

import com.example.daggerpracticemaster.MainActivity
import dagger.Component

@Component(modules = [(WheelModule::class),(DieselEngineModule::class)])
interface CarComponent {

    //fun getCarComponent():Car

    fun injectActivity(mainActivity: MainActivity){

    }
}