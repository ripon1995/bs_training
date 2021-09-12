package com.example.basicmvvmwithdiwithgenericviewmodelfactory.di.typeCode

import com.example.basicmvvmwithdiwithgenericviewmodelfactory.ui.activity.TypeCodeDataActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TypeCodeActivityModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): TypeCodeDataActivity
}