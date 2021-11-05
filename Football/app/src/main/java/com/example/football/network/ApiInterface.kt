package com.example.football.network

import com.example.football.datasource.model.competition.CompetitionList
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers


interface ApiInterface {

    @Headers("X-Auth-Token:" + "5a8f503824cf4eb3809d359e21356d4c")
    @GET("competitions/")
    fun getCompetitions(): Observable<Response<CompetitionList>>
}