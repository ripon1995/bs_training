package com.example.hotelorderwithdi.dataSource.remoteDataSource


import com.example.hotelorder.dataSource.model.Order
import com.example.hotelorder.network.ApiInterface
import com.example.hotelorder.network.RetrofitApiClient
import io.reactivex.Observable
import javax.inject.Inject

class RestApiDataSourceImplementation @Inject constructor(): RestApiDataSource {

    private val apiInterface: ApiInterface =
        RetrofitApiClient.getClient()!!.create(ApiInterface::class.java)

    override fun fetchOrderDetails(): Observable<Order> {
        return apiInterface.getData()
    }
}