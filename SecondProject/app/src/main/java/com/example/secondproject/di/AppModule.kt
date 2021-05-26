package com.example.secondproject.di

import androidx.lifecycle.ViewModelProvider
import com.example.secondproject.AppViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract  fun bindViewModelFactory(appViewModelFactory: AppViewModelFactory):ViewModelProvider.Factory
}