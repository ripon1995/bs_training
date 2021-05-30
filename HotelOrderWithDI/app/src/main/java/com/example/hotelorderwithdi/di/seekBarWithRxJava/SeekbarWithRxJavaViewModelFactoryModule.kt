package com.example.hotelorderwithdi.di.seekBarWithRxJava

import androidx.lifecycle.ViewModelProvider
import com.example.hotelorderwithdi.viewModel.seekBarWithRxJava.SeekBarWithRxJavaViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class SeekbarWithRxJavaViewModelFactoryModule {

    @Binds
    abstract fun bindSeekBarWithRxJavaViewModelFactory(seekBarWithRxJavaViewModelFactory: SeekBarWithRxJavaViewModelFactory):ViewModelProvider.Factory
}