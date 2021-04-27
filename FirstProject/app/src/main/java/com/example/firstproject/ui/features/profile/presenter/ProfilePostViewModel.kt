package com.example.firstproject.ui.features.profile.presenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstproject.dataSource.RestApiDataSource
import com.example.firstproject.dataSource.model.PostData
import com.example.firstproject.dataSource.model.ProfileOwner
import com.example.firstproject.dataSource.model.ProfilePost
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ProfilePostViewModel @Inject constructor(
    private val restApiDataSource: RestApiDataSource,
) : ViewModel() {
    val profilePostListLiveData = MutableLiveData<List<ProfilePost>>()
    val profileInfoListLiveData = MutableLiveData<ProfileOwner>()
    fun fetchProfilePost(id: String) {

        restApiDataSource.fetchProfilePost(id).enqueue(object : Callback<PostData?> {
            val dataList = mutableListOf<ProfilePost>()
            override fun onResponse(call: Call<PostData?>, response: Response<PostData?>) {
                val myResponse = response.body()
                val list: List<ProfilePost>
                if (response.code() == 200 && myResponse != null) {
                    list = myResponse.data
                    dataList.addAll(list)
                    //profileView.showProfilePostList(dataList)
                    //view.get()?.showProfilePostList(dataList)
                    profilePostListLiveData.value = dataList
                }


            }


            override fun onFailure(call: Call<PostData?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun fetchProfileInfo(id: String) {
        restApiDataSource.fetchProfileDetails(id).enqueue(object : Callback<ProfileOwner?> {
            override fun onResponse(call: Call<ProfileOwner?>, response: Response<ProfileOwner?>) {
                val data: ProfileOwner
                val myResponse = response.body()
                if (response.code() == 200 && myResponse != null) {
                    data = myResponse
                    //profileView.showProfileInfoDetails(data)
                    //view.get()?.showProfileInfoDetails(data)
                    profileInfoListLiveData.value = data
                }
            }

            override fun onFailure(call: Call<ProfileOwner?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}