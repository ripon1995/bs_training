package com.example.hotelorderwithdi.di.seekBarWithRxJava

import com.example.hotelorderwithdi.ui.activity.seekBarWithRxJava.SeekBarTestActivityWithRXJava
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SeekBarWithRxJavaActivityModule {

    @ContributesAndroidInjector
    abstract fun bindSeekBarActivityWithRxJava(): SeekBarTestActivityWithRXJava
}