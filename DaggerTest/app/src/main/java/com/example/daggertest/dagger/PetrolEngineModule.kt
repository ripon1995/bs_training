package com.example.daggertest.dagger

import com.example.daggertest.car.Engine
import com.example.daggertest.car.PetrolEngine
import dagger.Binds
import dagger.Module

@Module
abstract class  PetrolEngineModule {

    @Binds
   abstract fun bindsPetrolEngine(engine: PetrolEngine): Engine
}