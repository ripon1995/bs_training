package com.example.basicmvvmpattern.network

import com.example.basicmvvmpattern.dataSource.model.Order
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiInterface {

    @GET("orders")
    fun getData(): Observable<Order>
}