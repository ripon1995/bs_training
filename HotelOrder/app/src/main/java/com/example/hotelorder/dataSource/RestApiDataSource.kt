package com.example.hotelorder.dataSource


import com.example.hotelorder.dataSource.model.Order
import io.reactivex.rxjava3.core.Observable

interface RestApiDataSource {

    fun fetchOrderDetails(): Observable<Order>
}