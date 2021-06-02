package com.example.hotelorderwithhilt.di

import androidx.lifecycle.ViewModel
import com.example.hotelorderwithhilt.viewModel.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainActivityViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMyViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel
}