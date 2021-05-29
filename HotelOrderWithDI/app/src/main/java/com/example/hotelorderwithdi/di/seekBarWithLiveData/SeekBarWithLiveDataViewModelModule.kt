package com.example.hotelorderwithdi.di.seekBarWithLiveData

import androidx.lifecycle.ViewModel
import com.example.hotelorderwithdi.viewModel.seekBarWithLiveData.SeekBarActivityWithLiveDataViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class SeekBarWithLiveDataViewModelModule {

    @Binds
    abstract fun bindSeekBarWithLiveDataViewModel(seekBarActivityWithLiveDataViewModel: SeekBarActivityWithLiveDataViewModel):ViewModel
}