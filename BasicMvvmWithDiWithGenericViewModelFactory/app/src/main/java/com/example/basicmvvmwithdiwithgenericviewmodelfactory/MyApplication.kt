package com.example.basicmvvmwithdiwithgenericviewmodelfactory

import com.example.basicmvvmwithdiwithgenericviewmodelfactory.di.DaggerMyComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class MyApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMyComponent.builder().create(this).build()
    }
}