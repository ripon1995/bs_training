package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di.hotelOrder

import androidx.lifecycle.ViewModel
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.viewModel.hotelOrder.HotelDataActivityViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class HotelDataActivityViewModelModule {

    @Binds
    abstract fun bindViewModel(hotelDataActivityViewModel: HotelDataActivityViewModel): ViewModel
}