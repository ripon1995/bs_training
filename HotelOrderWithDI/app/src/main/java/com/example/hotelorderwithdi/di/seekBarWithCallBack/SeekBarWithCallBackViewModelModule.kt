package com.example.hotelorderwithdi.di.seekBarWithCallBack

import androidx.lifecycle.ViewModel
import com.example.hotelorderwithdi.di.ViewModelKey
import com.example.hotelorderwithdi.viewModel.seekBarWithCallBack.SeekBarActivityWithCallBackViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SeekBarWithCallBackViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SeekBarActivityWithCallBackViewModel::class)
    abstract fun bindSeekBarActivityWithCallBackViewModel(seekBarActivityWithCallBackViewModel: SeekBarActivityWithCallBackViewModel): ViewModel
}