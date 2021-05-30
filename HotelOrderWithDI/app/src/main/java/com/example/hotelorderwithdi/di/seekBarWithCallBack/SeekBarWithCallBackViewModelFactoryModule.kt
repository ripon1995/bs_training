package com.example.hotelorderwithdi.di.seekBarWithCallBack

import androidx.lifecycle.ViewModelProvider
import com.example.hotelorderwithdi.viewModel.seekBarWithCallBack.SeekBarActivityWithCallBackViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class SeekBarWithCallBackViewModelFactoryModule {

    @Binds
    abstract fun bindSeekBarWithCallBackViewModelFactory(seekBarActivityWithCallBackViewModelFactory: SeekBarActivityWithCallBackViewModelFactory):ViewModelProvider.Factory
}