package com.example.hotelorderwithdi.di.mainActivity

import androidx.lifecycle.ViewModelProvider
import com.example.hotelorderwithdi.viewModel.mainActivity.SampleViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityViewModelFactoryModule {

    @Binds
    abstract fun bindMainActivityViewModelFactory(sampleViewModelFactory: SampleViewModelFactory): ViewModelProvider.Factory
}