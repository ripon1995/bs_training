package com.example.hotelorderwithdi.di

import androidx.lifecycle.ViewModel
import com.example.hotelorderwithdi.viewModel.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MyViewModelModule {

    @Binds
    abstract fun bindMyViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel
}