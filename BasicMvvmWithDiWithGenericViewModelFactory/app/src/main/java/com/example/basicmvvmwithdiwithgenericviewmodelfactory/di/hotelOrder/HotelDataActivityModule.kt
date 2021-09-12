package com.example.basicmvvmwithdiwithgenericviewmodelfactory.di.hotelOrder

import com.example.basicmvvmwithdiwithgenericviewmodelfactory.ui.activity.HotelDataActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HotelDataActivityModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): HotelDataActivity
}