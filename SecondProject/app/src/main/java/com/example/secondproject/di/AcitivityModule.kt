package com.example.secondproject.di

import com.example.secondproject.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AcitivityModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity():MainActivity
}