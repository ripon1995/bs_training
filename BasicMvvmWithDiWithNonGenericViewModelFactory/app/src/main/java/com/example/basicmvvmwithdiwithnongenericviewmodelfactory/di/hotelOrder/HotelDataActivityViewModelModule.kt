package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di.hotelOrder

import androidx.lifecycle.ViewModel
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di.ViewModelKey
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.viewModel.hotelOrder.HotelDataActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HotelDataActivityViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HotelDataActivityViewModel::class)

    abstract fun bindViewModel(hotelDataActivityViewModel: HotelDataActivityViewModel): ViewModel
}