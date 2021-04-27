package com.example.daggertest.dagger

import com.example.daggertest.car.Rim
import com.example.daggertest.car.Tires
import com.example.daggertest.car.Wheel
import dagger.Module
import dagger.Provides

@Module
class WheelsModule  {

    @Provides
    fun provideRims(): Rim {
        return  Rim()
    }

    @Provides
    fun provideTires(): Tires {
        val tires = Tires()
        tires.inflate()
        return tires
    }

    @Provides
    fun proviesWheels(rim: Rim, tires: Tires): Wheel {

        return Wheel(rim,tires)
    }
}