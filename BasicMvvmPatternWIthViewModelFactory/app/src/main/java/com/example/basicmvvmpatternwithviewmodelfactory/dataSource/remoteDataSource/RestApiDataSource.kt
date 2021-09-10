package com.example.basicmvvmpatternwithviewmodelfactory.dataSource.remoteDataSource


import com.example.basicmvvmpatternwithviewmodelfactory.dataSource.model.Order
import io.reactivex.rxjava3.core.Observable

interface RestApiDataSource {

    fun fetchOrderDetails(): Observable<Order>
}