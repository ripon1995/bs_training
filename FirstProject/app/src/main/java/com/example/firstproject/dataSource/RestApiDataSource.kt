package com.example.firstproject.dataSource

import com.example.firstproject.dataSource.model.PostData
import com.example.firstproject.dataSource.model.UserData
import retrofit2.Call

interface RestApiDataSource {

    fun fetchNews(): Call<UserData>

    fun getProfile(id: String): Call<PostData>
}