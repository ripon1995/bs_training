package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di.typeCode

import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.ui.activity.TypeCodeDataActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TypeCodeActivityModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): TypeCodeDataActivity
}