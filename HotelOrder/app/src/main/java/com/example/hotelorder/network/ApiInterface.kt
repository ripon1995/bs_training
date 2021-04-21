package com.example.hotelorder.network

import com.example.hotelorder.dataSource.model.Order
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("orders")
    fun getData(): Call<Order>
}