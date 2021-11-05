package com.example.football.ui.competition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.football.R
import com.example.football.datasource.model.competition.CompetitionSingle
import com.example.football.viewmodel.CompetitionViewModel

class CompetitionActivity : AppCompatActivity() {
    private lateinit var viewModel :CompetitionViewModel
    private lateinit var competitionAdapter: CompetitionAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_competition)

        viewModel= ViewModelProvider(this)[CompetitionViewModel::class.java]
        viewModel.fetchCompetitions()
        viewModel.competitionLiveData.observe(this,{
            println(it.competitions.size)
            showCompetitions(it.competitions)
        })

    }

    private  fun showCompetitions(competitions:List<CompetitionSingle>){
        val recyclerView = findViewById<RecyclerView>(R.id.rvCompetition)
        competitionAdapter = CompetitionAdapter(competitions)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = competitionAdapter
    }
}