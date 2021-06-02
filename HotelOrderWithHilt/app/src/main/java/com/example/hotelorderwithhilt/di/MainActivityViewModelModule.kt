package com.example.hotelorderwithdi.di.mainActivity

import androidx.lifecycle.ViewModel
import com.example.hotelorderwithdi.di.ViewModelKey
import com.example.hotelorderwithdi.viewModel.mainActivity.MainActivityViewModel
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