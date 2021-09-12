package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di.hotelOrder

import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.ui.activity.HotelDataActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HotelDataActivityModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): HotelDataActivity
}