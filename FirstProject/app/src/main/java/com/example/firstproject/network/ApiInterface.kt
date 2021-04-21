package com.example.firstproject.network

import com.example.firstproject.dataSource.model.UserData
import com.example.firstproject.dataSource.model.PostData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiInterface {

    @Headers("app-id: " + "6073fd924066950e4508818d")
    @GET("post")
    fun getData(): Call<UserData>

    @Headers("app-id: " + "6073fd924066950e4508818d")
    @GET("user/{id}/post")
    fun getPost(@Path(value = "id") id: String):Call<PostData>
}