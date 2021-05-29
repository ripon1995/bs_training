package com.example.hotelorderwithdi.di.seekBarWithRxJava

import androidx.lifecycle.ViewModel
import com.example.hotelorderwithdi.viewModel.seekBarWithRxJava.SeekBarTestActivityWithRXjavaViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class SeekBarWithRxJavaViewModelModule {

    @Binds
    abstract fun bindSeekBarTestActivityWithRxJavaViewModel(seekBarTestActivityWithRXjavaViewModel: SeekBarTestActivityWithRXjavaViewModel): ViewModel

}