package com.example.secondproject.repository

import com.example.secondproject.repository.model.NewsStoryDetails
import com.example.secondproject.network.ApiInterface
import com.example.secondproject.network.RetrofitApiClient
import io.reactivex.Observable
import javax.inject.Inject

class RestApiDataSourceImplementation @Inject constructor() : RestApiDataSource {

    private val apiInterface: ApiInterface =
        RetrofitApiClient.getId()!!.create(ApiInterface::class.java)

    override fun fetchNewsId(): Observable<ArrayList<Int>> {
        return apiInterface.getID()
    }

    override fun fetchNewsSotriesDetails(id: Int): Observable<NewsStoryDetails> {
        return apiInterface.getNewsStoryDetails(id)
    }


}