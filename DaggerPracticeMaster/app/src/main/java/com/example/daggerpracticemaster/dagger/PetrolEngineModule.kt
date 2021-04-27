package com.example.daggerpracticemaster.dagger

import com.example.daggerpracticemaster.car.Engine
import com.example.daggerpracticemaster.car.PetrolEngine
import dagger.Binds
import dagger.Module

@Module
abstract class PetrolEngineModule {



    @Binds
    abstract fun bindPetrolEngine(engine: PetrolEngine): Engine

}
