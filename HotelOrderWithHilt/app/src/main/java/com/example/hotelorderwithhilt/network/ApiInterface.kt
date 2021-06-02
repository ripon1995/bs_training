package com.example.hotelorder.network

import com.example.hotelorderwithhilt.dataSource.model.Order
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {

    @GET("orders")
    fun getData(): Observable<Order>
}