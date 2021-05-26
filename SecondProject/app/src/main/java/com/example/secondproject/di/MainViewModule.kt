package com.example.secondproject.di

import androidx.lifecycle.ViewModel
import com.example.secondproject.viewModel.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMyViewModel(myViewModel: MainActivityViewModel): ViewModel
}