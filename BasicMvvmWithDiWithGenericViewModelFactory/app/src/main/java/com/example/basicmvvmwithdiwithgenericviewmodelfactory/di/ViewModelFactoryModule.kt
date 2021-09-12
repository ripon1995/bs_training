package com.example.basicmvvmwithdiwithgenericviewmodelfactory.di

import androidx.lifecycle.ViewModelProvider
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.viewModel.AppViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(appViewModelFactory: AppViewModelFactory): ViewModelProvider.Factory

}