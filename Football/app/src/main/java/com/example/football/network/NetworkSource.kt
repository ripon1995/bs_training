package com.example.football.network

import com.example.football.datasource.model.competition.CompetitionList
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response

interface NetworkSource {
    fun getCompetitions():Observable<Response<CompetitionList>>
}