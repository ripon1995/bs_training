package com.example.hotelorderwithdi.di.mainActivity2

import androidx.lifecycle.ViewModel
import com.example.hotelorderwithdi.di.ViewModelKey
import com.example.hotelorderwithdi.viewModel.mainActivity2.MainActivity2ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainActivity2ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivity2ViewModel::class)
    abstract fun bindMainActivity2ViewModel(mainActivity2ViewModel: MainActivity2ViewModel): ViewModel
}