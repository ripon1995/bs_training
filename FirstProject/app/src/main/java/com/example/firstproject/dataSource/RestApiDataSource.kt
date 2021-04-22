package com.example.firstproject.dataSource

import com.example.firstproject.dataSource.model.PostData
import com.example.firstproject.dataSource.model.ProfileOwner
import com.example.firstproject.dataSource.model.UserData
import retrofit2.Call

interface RestApiDataSource {

    fun fetchNews(): Call<UserData>
    fun fetchProfilePost(id: String): Call<PostData>

    fun fetchProfileDetails(id:String):Call<ProfileOwner>
}