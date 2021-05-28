package com.example.hotelorderwithdi.di

import com.example.hotelorderwithdi.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}