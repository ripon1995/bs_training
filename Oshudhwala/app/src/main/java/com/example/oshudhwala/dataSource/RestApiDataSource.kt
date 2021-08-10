package com.example.oshudhwala.dataSource

import androidx.lifecycle.MutableLiveData
import com.example.oshudhwala.dataSource.model.Medicine
import com.example.oshudhwala.dataSource.model.MedicineKey
import io.reactivex.Observable

import kotlin.collections.ArrayList

interface RestApiDataSource {

    fun getMedicine(listener:RestApiDataSourceImplementation.LoadStatus)

    fun orderedMedicine(listener: RestApiDataSourceImplementation.OrderDetails)

}