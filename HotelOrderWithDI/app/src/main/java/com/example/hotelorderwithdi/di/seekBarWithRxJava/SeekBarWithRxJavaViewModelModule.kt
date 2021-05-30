package com.example.hotelorderwithdi.di.seekBarWithRxJava

import androidx.lifecycle.ViewModel
import com.example.hotelorderwithdi.di.ViewModelKey
import com.example.hotelorderwithdi.viewModel.seekBarWithRxJava.SeekBarTestActivityWithRXjavaViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SeekBarWithRxJavaViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SeekBarTestActivityWithRXjavaViewModel::class)
    abstract fun bindSeekBarTestActivityWithRxJavaViewModel(seekBarTestActivityWithRXjavaViewModel: SeekBarTestActivityWithRXjavaViewModel): ViewModel

}