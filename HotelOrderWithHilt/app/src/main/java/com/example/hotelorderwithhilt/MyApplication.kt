package com.example.hotelorderwithdi

import com.example.hotelorderwithdi.di.DaggerMyComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


open class MyApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerMyComponent.builder().create(this).build()

    }
}