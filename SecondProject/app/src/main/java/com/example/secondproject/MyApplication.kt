package com.example.secondproject

import com.example.secondproject.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


open class MyApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerAppComponent.builder().create(this).build()

    }
}