package com.example.basicmvvmwithdiwithgenericviewmodelfactory.network

import com.example.basicmvvmwithdiwithgenericviewmodelfactory.dataSource.model.hotelData.Order
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.dataSource.model.typeCodeData.Posts
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiInterface {

    @GET("orders")
    fun getData(): Observable<Order>

    @GET("posts")
    fun getPost(): Observable<Posts>
}