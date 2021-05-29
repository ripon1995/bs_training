package com.example.hotelorderwithdi.di.seekBarWithCallBack

import com.example.hotelorderwithdi.ui.activity.seekBarWithCallBack.SeekBarActivityWithCallBack
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SeekBarWithCallBackActivityModule {

    @ContributesAndroidInjector
    abstract fun bindSeekBarActivityWithCallBack():SeekBarActivityWithCallBack
}