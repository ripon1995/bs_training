package com.example.hotelorderwithdi.dataSource.remoteDataSource

import com.example.hotelorder.dataSource.model.Order
import io.reactivex.Observable

interface RestApiDataSource {

    fun fetchOrderDetails(): Observable<Order>
}