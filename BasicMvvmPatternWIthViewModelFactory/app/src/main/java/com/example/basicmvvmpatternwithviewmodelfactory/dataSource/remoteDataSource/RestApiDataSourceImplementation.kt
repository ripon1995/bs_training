package com.example.basicmvvmpatternwithviewmodelfactory.dataSource.remoteDataSource

import com.example.basicmvvmpatternwithviewmodelfactory.dataSource.model.Order
import com.example.basicmvvmpatternwithviewmodelfactory.network.ApiInterface
import com.example.basicmvvmpatternwithviewmodelfactory.network.RetrofitApiClient
import io.reactivex.rxjava3.core.Observable


class RestApiDataSourceImplementation : RestApiDataSource {

    private val apiInterface: ApiInterface =
        RetrofitApiClient.getClient()!!.create(ApiInterface::class.java)

    override fun fetchOrderDetails(): Observable<Order> {
        return apiInterface.getData()
    }
}