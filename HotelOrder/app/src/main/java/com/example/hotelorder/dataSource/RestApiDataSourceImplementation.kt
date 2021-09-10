package com.example.hotelorder.dataSource

import com.example.hotelorder.dataSource.model.Order
import com.example.hotelorder.network.ApiInterface
import com.example.hotelorder.network.RetrofitApiClient
import io.reactivex.rxjava3.core.Observable


class RestApiDataSourceImplementation : RestApiDataSource {

    private val apiInterface: ApiInterface =
        RetrofitApiClient.getClient()!!.create(ApiInterface::class.java)

    override fun fetchOrderDetails(): Observable<Order> {
        return apiInterface.getData()
    }
}