package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.network

import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.model.hotelData.Order
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.model.typeCodeData.Posts
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiInterface {

    @GET("orders")
    fun getData(): Observable<Order>

    @GET("posts")
    fun getPost(): Observable<Posts>
}