package com.example.hotelorderwithdi.di.mainActivity

import androidx.lifecycle.ViewModel
import com.example.hotelorderwithdi.viewModel.mainActivity.MainActivityViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityViewModelModule {

    @Binds
    abstract fun bindMyViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel
}