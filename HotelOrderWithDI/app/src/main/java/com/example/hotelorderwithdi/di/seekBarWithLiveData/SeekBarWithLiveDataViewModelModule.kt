package com.example.hotelorderwithdi.di.seekBarWithLiveData

import androidx.lifecycle.ViewModel
import com.example.hotelorderwithdi.di.ViewModelKey
import com.example.hotelorderwithdi.viewModel.seekBarWithLiveData.SeekBarActivityWithLiveDataViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SeekBarWithLiveDataViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SeekBarActivityWithLiveDataViewModel::class)
    abstract fun bindSeekBarWithLiveDataViewModel(seekBarActivityWithLiveDataViewModel: SeekBarActivityWithLiveDataViewModel): ViewModel
}