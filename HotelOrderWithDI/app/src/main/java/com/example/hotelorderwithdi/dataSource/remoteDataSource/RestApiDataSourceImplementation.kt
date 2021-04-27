package com.example.hotelorder.dataSource

import com.example.hotelorder.dataSource.model.Order
import com.example.hotelorder.network.ApiInterface
import com.example.hotelorder.network.RetrofitApiClient
import retrofit2.Call

class RestApiDataSourceImplementation : RestApiDataSource {

    private val apiInterface: ApiInterface =
        RetrofitApiClient.getClient()!!.create(ApiInterface::class.java)

    override fun fetchOrderDetails(): Call<Order> {
        return apiInterface.getData()
    }
}