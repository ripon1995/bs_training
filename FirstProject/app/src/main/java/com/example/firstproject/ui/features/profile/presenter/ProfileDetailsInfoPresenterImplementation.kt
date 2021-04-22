package com.example.firstproject.ui.features.profile.presenter

import com.example.firstproject.dataSource.RestApiDataSource
import com.example.firstproject.dataSource.model.ProfileOwner
import com.example.firstproject.ui.features.profile.view.ProfileView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileDetailsInfoPresenterImplementation(
    private val restApiDataSource: RestApiDataSource,
    private val profileView: ProfileView,
) : ProfileDetailsInfoPresenter {


    override fun fetchProfileInfo(id: String) {

        restApiDataSource.fetchProfileDetails(id).enqueue(object : Callback<ProfileOwner?> {
            override fun onResponse(call: Call<ProfileOwner?>, response: Response<ProfileOwner?>) {
                val data: ProfileOwner
                val myResponse = response.body()
                if (response.code() == 200 && myResponse != null) {
                    data = myResponse
                    profileView.showProfileInfoDetails(data)
                }
            }

            override fun onFailure(call: Call<ProfileOwner?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}