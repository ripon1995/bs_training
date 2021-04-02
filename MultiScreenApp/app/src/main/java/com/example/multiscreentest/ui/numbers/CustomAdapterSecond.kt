package com.example.multiscreentest.ui.numbers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.multiscreentest.R

internal class CustomAdapterSecond(private var itemList: List<Word>) :
        RecyclerView.Adapter<CustomAdapterSecond.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemFirst = itemList[position].mWord
        val itemSecond = itemList[position].nWord

        holder.itemTextView.text = itemFirst;
        holder.itemTextView1.text = itemSecond
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTextView: TextView = view.findViewById(R.id.itemTextView)
        var itemTextView1: TextView = view.findViewById(R.id.itemTextView1)
    }
}