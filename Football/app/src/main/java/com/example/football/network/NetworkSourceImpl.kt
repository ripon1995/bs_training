package com.example.football.network

import com.example.football.datasource.model.competition.CompetitionList
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response

class NetworkSourceImpl : NetworkSource {
    private val apiInterface: ApiInterface =
        NetworkFactory.getClient()!!.create(ApiInterface::class.java)

    override fun getCompetitions(): Observable<Response<CompetitionList>> {
        return apiInterface.getCompetitions()
    }
}