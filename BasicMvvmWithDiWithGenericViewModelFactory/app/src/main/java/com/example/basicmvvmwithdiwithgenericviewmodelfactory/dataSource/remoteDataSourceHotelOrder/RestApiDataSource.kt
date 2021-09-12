package com.example.basicmvvmwithdiwithgenericviewmodelfactory.dataSource.remoteDataSourceHotelOrder


import com.example.basicmvvmwithdiwithgenericviewmodelfactory.dataSource.model.hotelData.Order
import io.reactivex.rxjava3.core.Observable

interface RestApiDataSource {

    fun fetchOrderDetails(): Observable<Order>

}