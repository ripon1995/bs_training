package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.remoteDataSourceHotelOrder


import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.model.hotelData.Order
import io.reactivex.rxjava3.core.Observable

interface RestApiDataSource {

    fun fetchOrderDetails(): Observable<Order>

}