package com.example.firstproject.di

import androidx.lifecycle.ViewModelProvider
import com.example.firstproject.ui.features.AppViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindAppViewModelFactory(appViewModelFactory: AppViewModelFactory): ViewModelProvider.Factory
}