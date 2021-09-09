package com.example.basicmvvmpattern.dataSource.remoteDataSource

import com.example.basicmvvmpattern.dataSource.model.Order
import com.example.basicmvvmpattern.network.ApiInterface
import com.example.basicmvvmpattern.network.RetrofitApiClient
import io.reactivex.rxjava3.core.Observable


class RestApiDataSourceImplementation : RestApiDataSource {

    private val apiInterface: ApiInterface =
        RetrofitApiClient.getClient()!!.create(ApiInterface::class.java)

    override fun fetchOrderDetails(): Observable<Order> {
        return apiInterface.getData()
    }
}