package com.example.hotelorder.dataSource

import com.example.hotelorder.dataSource.model.Order
import retrofit2.Call

interface RestApiDataSource {

    fun fetchOrderDetails(): Call<Order>
}