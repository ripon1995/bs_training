package com.example.hotelorderwithdi.di.seekBarWithCallBack

import androidx.lifecycle.ViewModel
import com.example.hotelorderwithdi.viewModel.seekBarWithCallBack.SeekBarActivityWithCallBackViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class SeekBarWithCallBackViewModelModule {

    @Binds
    abstract fun bindSeekBarActivityWithCallBackViewModel(seekBarActivityWithCallBackViewModel: SeekBarActivityWithCallBackViewModel): ViewModel
}