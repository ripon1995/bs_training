package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.viewModel.hotelOrder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.remoteDataSourceHotelOrder.RestApiDataSourceImplementation
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HotelDataAcitivityViewModelFactory @Inject constructor(val restApiDataSourceImplementation: RestApiDataSourceImplementation) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(RestApiDataSourceImplementation::class.java)
            .newInstance(restApiDataSourceImplementation)
    }
}