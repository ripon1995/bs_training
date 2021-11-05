package com.example.football.ui.competition

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.football.R
import com.example.football.datasource.model.competition.CompetitionSingle
import com.google.android.material.textview.MaterialTextView

class CompetitionAdapter(private val competitionList:List<CompetitionSingle>):RecyclerView.Adapter<CompetitionAdapter.ViewHolder>() {

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val competitionName : MaterialTextView=view.findViewById(R.id.tvCompetitionName)
        val startDate:MaterialTextView = view.findViewById(R.id.tvStartDate)
        val endDate:MaterialTextView= view.findViewById(R.id.tvEndDate)
        val winner:MaterialTextView = view.findViewById(R.id.tvWinnerName)
        val hostFlag:AppCompatImageView=view.findViewById(R.id.ivHostFlag)
        val winnerFlag:AppCompatImageView=view.findViewById(R.id.ivWinnerFlag)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.competition_details,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.competitionName.text=competitionList[position].name
        if(competitionList[position].currentSeason.startDate!=null)holder.startDate.text=competitionList[position].currentSeason.startDate
        else holder.startDate.text="No date"
        if(competitionList[position].currentSeason.endDate!=null)holder.startDate.text=competitionList[position].currentSeason.endDate
        else holder.endDate.text="No date"
        if(competitionList[position].currentSeason.winner!=null)holder.winner.text=competitionList[position].currentSeason.winner.name
        else holder.winner.text="No Result"

        if(competitionList[position].area.ensignUrl!=null)holder.hostFlag.setImageURI(Uri.parse(competitionList[position].area.ensignUrl))
        else holder.hostFlag.setImageResource(R.drawable.image)
        if(competitionList[position].currentSeason.winner!=null)holder.winnerFlag.setImageURI(Uri.parse(competitionList[position].currentSeason.winner.crestUrl))
        else holder.winnerFlag.setImageResource(R.drawable.image)
    }

    override fun getItemCount(): Int {
        return competitionList.size
    }

}