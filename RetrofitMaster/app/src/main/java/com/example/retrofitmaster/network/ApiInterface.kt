package com.example.retrofitmaster.network

import com.example.retrofitmaster.model.MyAlbumsItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface  {

    @GET("albums")
    fun getAlbums():Call<List<MyAlbumsItem>>
}