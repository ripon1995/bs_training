package com.example.hotelorderwithdi.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hotelorderwithdi.dataSource.model.SeekbarTest

class MainActivity2ViewModelFactory :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor()
            .newInstance()
    }
}