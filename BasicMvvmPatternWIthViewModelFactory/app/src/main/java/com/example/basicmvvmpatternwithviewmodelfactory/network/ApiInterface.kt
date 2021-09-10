package com.example.basicmvvmpatternwithviewmodelfactory.network

import com.example.basicmvvmpatternwithviewmodelfactory.dataSource.model.Order
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiInterface {

    @GET("orders")
    fun getData(): Observable<Order>
}