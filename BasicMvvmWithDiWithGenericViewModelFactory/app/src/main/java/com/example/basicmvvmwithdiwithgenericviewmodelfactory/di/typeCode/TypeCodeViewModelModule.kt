package com.example.basicmvvmwithdiwithgenericviewmodelfactory.di.typeCode

import androidx.lifecycle.ViewModel
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.di.ViewModelKey
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.viewModel.typeCode.TypeCodeViewModel
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