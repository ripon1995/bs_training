package com.example.football.datasource.remoteDataSource

import com.example.football.datasource.model.competition.CompetitionList
import io.reactivex.rxjava3.core.Observable


interface RestDataSource {
    fun getCompetitions(): Observable<CompetitionList>
}