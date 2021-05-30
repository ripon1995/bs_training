package com.example.hotelorderwithdi.viewModel.seekBarWithCallBack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SeekBarActivityWithCallBackViewModelFactory @Inject constructor(): ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor().newInstance()
    }
}