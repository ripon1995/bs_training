package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di.hotelOrder

import androidx.lifecycle.ViewModelProvider
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.viewModel.hotelOrder.HotelDataAcitivityViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class HotelDataActivityViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(hotelDataAcitivityViewModelFactory: HotelDataAcitivityViewModelFactory): ViewModelProvider.Factory
}