package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di.typeCode

import androidx.lifecycle.ViewModel
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.viewModel.typeCode.TypeCodeViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class TypeCodeViewModelModule {
    @Binds
    abstract fun bindViewModel(typeCodeViewModel: TypeCodeViewModel): ViewModel
}