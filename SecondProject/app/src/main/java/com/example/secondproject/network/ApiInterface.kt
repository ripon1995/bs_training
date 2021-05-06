package com.example.secondproject.network

import com.example.secondproject.dataSource.model.NewsStoryDetails
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("topstories.json?print=pretty")
    fun getID():Observable<ArrayList<Int>>

    @GET("item/{id}.json?print=pretty")
    fun getNewsStoryDetails(@Path(value = "id")id:Int): Observable<NewsStoryDetails>

}