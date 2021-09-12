package com.example.basicmvvmwithdiwithgenericviewmodelfactory.dataSource.remoteDataSourceHotelOrder

import com.example.basicmvvmwithdiwithgenericviewmodelfactory.dataSource.model.hotelData.Order
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.network.ApiInterface
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.network.RetrofitApiClientHotelData
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject


class RestApiDataSourceImplementation @Inject constructor() : RestApiDataSource {

    private val apiInterface: ApiInterface =
        RetrofitApiClientHotelData.getClient()!!.create(ApiInterface::class.java)

    override fun fetchOrderDetails(): Observable<Order> {
        return apiInterface.getData()
    }

}