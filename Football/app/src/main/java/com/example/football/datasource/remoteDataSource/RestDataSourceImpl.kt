package com.example.football.datasource.remoteDataSource

import com.example.football.datasource.model.competition.CompetitionList
import com.example.football.network.NetworkSourceImpl
import io.reactivex.rxjava3.core.Observable

class RestDataSourceImpl : RestDataSource {

    private val networkSource = NetworkSourceImpl()

    override fun getCompetitions(): Observable<CompetitionList> {
        return networkSource.getCompetitions().map {
            it.body()!!
        }
    }
}