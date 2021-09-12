package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di.typeCode

import androidx.lifecycle.ViewModelProvider
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.viewModel.hotelOrder.HotelDataAcitivityViewModelFactory
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.viewModel.typeCode.TypeCodeViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class TypeCodeViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(typeCodeViewModelFactory: TypeCodeViewModelFactory): ViewModelProvider.Factory
}