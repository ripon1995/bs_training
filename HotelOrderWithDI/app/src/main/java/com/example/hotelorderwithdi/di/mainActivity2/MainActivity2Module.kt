package com.example.hotelorderwithdi.di.mainActivity2

import com.example.hotelorderwithdi.ui.activity.mainActivity2.MainActivity2
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivity2Module {

    @ContributesAndroidInjector
    abstract fun bindMainActivity2():MainActivity2
}