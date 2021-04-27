package com.example.firstproject.dataSource

import com.example.firstproject.dataSource.model.PostData
import com.example.firstproject.dataSource.model.ProfileOwner
import com.example.firstproject.dataSource.model.UserData
import com.example.firstproject.network.ApiInterface
import com.example.firstproject.network.RetrofitApiClient
import retrofit2.Call
import javax.inject.Inject

class RestApiDataSourceImplementation @Inject constructor() : RestApiDataSource {

    private val apiInterface: ApiInterface =
        RetrofitApiClient.getClient()!!.create(ApiInterface::class.java)

    override fun fetchNews(): Call<UserData> {
        return apiInterface.getData()
    }

    override fun fetchProfilePost(id: String): Call<PostData> {
        return apiInterface.getPost(id)
    }

    override fun fetchProfileDetails(id: String): Call<ProfileOwner> {
        return apiInterface.getProfileDetails(id)
    }
}