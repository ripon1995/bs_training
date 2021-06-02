package com.example.hotelorderwithhilt


import com.example.hotelorderwithhilt.di.DaggerMyComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


open class MyApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerMyComponent.builder().create(this).build()

    }
}