package com.example.secondproject.dataSource

import com.example.secondproject.dataSource.model.NewsStoryDetails
import com.example.secondproject.network.ApiInterface
import com.example.secondproject.network.RetrofitApiClient
import io.reactivex.Observable

class RestApiDataSourceImplementation : RestApiDataSource {

    private val apiInterface: ApiInterface =
        RetrofitApiClient.getId()!!.create(ApiInterface::class.java)

    override fun fetchNewsId(): Observable<ArrayList<Int>> {
        return apiInterface.getID()
    }

    override fun fetchNewsSotriesDetails(id: Int): Observable<NewsStoryDetails> {
        return apiInterface.getNewsStoryDetails(id)
    }


}