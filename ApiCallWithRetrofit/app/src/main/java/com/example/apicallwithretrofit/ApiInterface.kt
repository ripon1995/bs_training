package com.example.firstproject.network

import com.example.firstproject.model.Data
import com.example.firstproject.model.MyData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiInterface {

    @Headers("app-id: " + "6073fd924066950e4508818d")
    @GET("post")
    fun getData(): Call<MyData>
}