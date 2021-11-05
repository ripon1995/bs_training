package com.example.football.datasource.model.competition

data class CompetitionSingle(
    val id: Int,
    val area: Area,
    val name: String,
    val code: String,
    val emblemUrl: String,
    val plan: String,
    val currentSeason: CurrentSeason,
    val numberOfAvailableSeasons: Int,
)
