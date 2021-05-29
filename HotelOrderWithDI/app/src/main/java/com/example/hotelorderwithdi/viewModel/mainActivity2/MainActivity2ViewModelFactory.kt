package com.example.hotelorderwithdi.viewModel.mainActivity2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hotelorderwithdi.dataSource.model.MainActivity2DataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainActivity2ViewModelFactory @Inject constructor(private val finalString: MainActivity2DataSource) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MainActivity2DataSource::class.java)
            .newInstance(finalString)
    }
}