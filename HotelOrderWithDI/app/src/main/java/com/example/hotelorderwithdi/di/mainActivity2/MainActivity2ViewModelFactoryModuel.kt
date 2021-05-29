package com.example.hotelorderwithdi.di.mainActivity2

import androidx.lifecycle.ViewModelProvider
import com.example.hotelorderwithdi.viewModel.mainActivity2.MainActivity2ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivity2ViewModelFactoryModuel {

    @Binds
    abstract fun bindMainActivity2ViewModelFactory(mainActivity2ViewModelFactory: MainActivity2ViewModelFactory): ViewModelProvider.Factory
}