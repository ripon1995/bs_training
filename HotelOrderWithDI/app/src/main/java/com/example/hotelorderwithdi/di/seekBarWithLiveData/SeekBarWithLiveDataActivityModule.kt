package com.example.hotelorderwithdi.di.seekBarWithLiveData

import com.example.hotelorderwithdi.ui.activity.seekBarWithLiveData.SeekBarActivityWithLiveData
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SeekBarWithLiveDataActivityModule {

    @ContributesAndroidInjector
    abstract fun bindSeekBarActivityWithLiveData(): SeekBarActivityWithLiveData
}