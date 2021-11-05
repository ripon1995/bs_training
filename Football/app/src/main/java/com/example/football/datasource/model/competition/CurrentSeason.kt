package com.example.football.datasource.model.competition

data class CurrentSeason(
    val id:Int,
    val startDate:String,
    val endDate:String,
    val currentMatchday:Int,
    val winner:Winner,
)
