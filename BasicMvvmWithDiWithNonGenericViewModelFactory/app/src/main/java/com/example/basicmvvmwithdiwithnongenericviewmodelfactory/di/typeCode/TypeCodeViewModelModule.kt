package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di.typeCode

import androidx.lifecycle.ViewModel
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di.ViewModelKey
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.viewModel.hotelOrder.HotelDataActivityViewModel
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.viewModel.typeCode.TypeCodeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class TypeCodeViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(TypeCodeViewModel::class)

    abstract fun bindViewModel(typeCodeViewModel: TypeCodeViewModel): ViewModel
}