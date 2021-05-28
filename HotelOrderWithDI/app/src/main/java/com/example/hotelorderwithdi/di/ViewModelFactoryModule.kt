package com.example.hotelorderwithdi.di

import androidx.lifecycle.ViewModelProvider
import com.example.hotelorderwithdi.viewModel.SampleViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(sampleViewModelFactory: SampleViewModelFactory): ViewModelProvider.Factory
}