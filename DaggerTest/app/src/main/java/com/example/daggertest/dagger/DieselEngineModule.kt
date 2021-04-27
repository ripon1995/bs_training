package com.example.daggertest.dagger

import com.example.daggertest.car.DieselEngine
import com.example.daggertest.car.Engine
import dagger.Binds
import dagger.Module

@Module
abstract class DieselEngineModule {

    @Binds
    abstract fun bindDieselEngine(engine: DieselEngine): Engine

}