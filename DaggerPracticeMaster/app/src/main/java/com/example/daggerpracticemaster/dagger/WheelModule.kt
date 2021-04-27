package com.example.daggerpracticemaster.dagger

import com.example.daggerpracticemaster.car.WheelRim
import com.example.daggerpracticemaster.car.WheelTyre
import com.example.daggerpracticemaster.car.Wheels
import dagger.Module
import dagger.Provides

@Module
class WheelModule {

    @Provides
    fun provideRim(): WheelRim {
        return WheelRim()
    }

    @Provides
    fun provideTire(): WheelTyre {
        return WheelTyre()
    }

    @Provides
    fun provideWheel(rim: WheelRim, tyre: WheelTyre): Wheels {
        return Wheels(rim,tyre)
    }
}