package com.example.hotelorderwithdi.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hotelorderwithdi.dataSource.remoteDataSource.RestApiDataSourceImplementation
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SampleViewModelFactory @Inject constructor(private val restApiDataSourceImplementation: RestApiDataSourceImplementation) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(RestApiDataSourceImplementation::class.java)
            .newInstance(restApiDataSourceImplementation)
    }
}