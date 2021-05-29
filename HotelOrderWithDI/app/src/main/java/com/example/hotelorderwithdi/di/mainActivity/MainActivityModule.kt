package com.example.hotelorderwithdi.di.mainActivity

import com.example.hotelorderwithdi.ui.activity.mainActivity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}