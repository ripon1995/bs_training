package com.example.hotelorderwithdi.di.seekBarWithLiveData

import androidx.lifecycle.ViewModelProvider
import com.example.hotelorderwithdi.viewModel.seekBarWithLiveData.SeekBarActivityWithLiveDataViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class SeekBarWithLiveDataViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(seekBarActivityWithLiveDataViewModelFactory: SeekBarActivityWithLiveDataViewModelFactory): ViewModelProvider.Factory
}