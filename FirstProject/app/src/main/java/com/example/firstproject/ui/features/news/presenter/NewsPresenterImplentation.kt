package com.example.firstproject.ui.features.news.presenter

import com.example.firstproject.dataSource.RestApiDataSource
import com.example.firstproject.dataSource.model.Post
import com.example.firstproject.dataSource.model.UserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NewsPresenterImplentation @Inject constructor(
    private val restApiDataSource: RestApiDataSource
) : NewsPresenter() {

    override fun fetchNews() {
        restApiDataSource.fetchNews().enqueue(object : Callback<UserData?> {
            val dataList = mutableListOf<Post>()
            override fun onResponse(call: Call<UserData?>, response: Response<UserData?>) {
                val myresponse = response.body()

                val list: List<Post>
                if (response.code() == 200 && myresponse != null) {
                    list = myresponse.data
                    dataList.addAll(list)
                    view.get()?.showNewsList(dataList)
                }
            }

            override fun onFailure(call: Call<UserData?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}