package com.example.secondproject.dataSource

import com.example.secondproject.dataSource.model.NewsStoryDetails
import io.reactivex.Observable

interface RestApiDataSource {

    //to fetch newsId
    fun fetchNewsId(): Observable<ArrayList<Int>>

    //to fetch newsDetails
    fun fetchNewsSotriesDetails(id: Int): Observable<NewsStoryDetails>
}