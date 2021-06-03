package com.example.hotelorderwithhilt.dataSource.remoteDataSource


import com.example.hotelorderwithhilt.network.ApiInterface
import com.example.hotelorder.network.RetrofitApiClient
import com.example.hotelorderwithhilt.dataSource.model.Order
import io.reactivex.Observable
import javax.inject.Inject

class RestApiDataSourceImplementation @Inject constructor() : RestApiDataSource {

    private val apiInterface: ApiInterface =
        RetrofitApiClient.getClient()!!.create(ApiInterface::class.java)

    override fun fetchOrderDetails(): Observable<Order> {
        return apiInterface.getData()
    }
}