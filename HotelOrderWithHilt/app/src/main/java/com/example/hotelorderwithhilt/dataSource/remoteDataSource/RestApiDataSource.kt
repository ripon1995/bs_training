package com.example.hotelorderwithhilt.dataSource.remoteDataSource

import com.example.hotelorderwithhilt.dataSource.model.Order
import io.reactivex.Observable

interface RestApiDataSource {

    fun fetchOrderDetails(): Observable<Order>
}