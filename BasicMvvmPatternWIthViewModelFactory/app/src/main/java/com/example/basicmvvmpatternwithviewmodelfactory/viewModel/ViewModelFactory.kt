package com.example.basicmvvmpatternwithviewmodelfactory.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basicmvvmpatternwithviewmodelfactory.dataSource.remoteDataSource.RestApiDataSourceImplementation

class ViewModelFactory(val restApiDataSourceImplementation: RestApiDataSourceImplementation) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(RestApiDataSourceImplementation::class.java)
            .newInstance(restApiDataSourceImplementation)
    }
}