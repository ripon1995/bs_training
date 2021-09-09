package com.example.basicmvvmpattern.dataSource.remoteDataSource


import com.example.basicmvvmpattern.dataSource.model.Order
import io.reactivex.rxjava3.core.Observable

interface RestApiDataSource {

    fun fetchOrderDetails(): Observable<Order>
}