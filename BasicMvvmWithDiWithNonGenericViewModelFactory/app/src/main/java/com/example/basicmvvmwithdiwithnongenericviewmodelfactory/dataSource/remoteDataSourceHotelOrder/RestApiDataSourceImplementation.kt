package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.remoteDataSourceHotelOrder

import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.model.hotelData.Order
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.network.ApiInterface
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.network.RetrofitApiClientHotelData
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject


class RestApiDataSourceImplementation @Inject constructor() : RestApiDataSource {

    private val apiInterface: ApiInterface =
        RetrofitApiClientHotelData.getClient()!!.create(ApiInterface::class.java)

    override fun fetchOrderDetails(): Observable<Order> {
        return apiInterface.getData()
    }

}