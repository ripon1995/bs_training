package com.example.firstproject.ui.features.profile.presenter

import com.example.firstproject.dataSource.RestApiDataSource
import com.example.firstproject.dataSource.model.PostData
import com.example.firstproject.dataSource.model.ProfilePost
import com.example.firstproject.ui.features.profile.view.ProfileView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfilePostPresenterImplementation(
    private val restApiDataSource: RestApiDataSource,
    private val profileView: ProfileView,

) : ProfilePostPresenter {
    override fun fetchProfilePost(id:String) {

        restApiDataSource.fetchProfilePost(id).enqueue(object : Callback<PostData?> {
            val dataList = mutableListOf<ProfilePost>()
            override fun onResponse(call: Call<PostData?>, response: Response<PostData?>) {
                val myResponse = response.body()
                val list: List<ProfilePost>
                if (response.code() == 200 && myResponse != null) {
                    list = myResponse.data
                    dataList.addAll(list)
                    profileView.showProfilePostList(dataList)
                }
            }


            override fun onFailure(call: Call<PostData?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}