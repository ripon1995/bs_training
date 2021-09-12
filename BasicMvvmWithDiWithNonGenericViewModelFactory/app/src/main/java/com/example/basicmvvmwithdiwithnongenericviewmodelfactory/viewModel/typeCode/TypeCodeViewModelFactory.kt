package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.viewModel.typeCode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.remoteDataSourceTypeCode.RestTypeCodeImplementation
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TypeCodeViewModelFactory @Inject constructor(private val restTypeCodeImplementation: RestTypeCodeImplementation) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(RestTypeCodeImplementation::class.java)
            .newInstance(restTypeCodeImplementation)
    }
}