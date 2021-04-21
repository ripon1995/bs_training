package com.example.firstproject.dataSource

import com.example.firstproject.dataSource.model.PostData
import com.example.firstproject.dataSource.model.UserData
import com.example.firstproject.network.ApiInterface
import com.example.firstproject.network.RetrofitApiClient
import retrofit2.Call

class RestApiDataSourceImplementation : RestApiDataSource {

    private val apiInterface: ApiInterface =
        RetrofitApiClient.getClient()!!.create(ApiInterface::class.java)
    override fun fetchNews(): Call<UserData> {
        return apiInterface.getData()
    }

    override fun getProfile(id:String): Call<PostData> {
        return apiInterface.getPost(id)
    }
}