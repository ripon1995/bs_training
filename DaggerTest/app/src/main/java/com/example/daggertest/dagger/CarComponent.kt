package com.example.daggertest.dagger

import com.example.daggertest.MainActivity
import dagger.Component

@Component (modules = [WheelsModule::class, DieselEngineModule::class])
interface CarComponent  {

    //fun getCarCompnonet():Car

    fun injectMain(mainActivity: MainActivity)
}