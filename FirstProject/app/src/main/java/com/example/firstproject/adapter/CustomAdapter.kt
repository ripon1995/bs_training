package com.example.firstproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R
import com.example.firstproject.model.Data
import com.squareup.picasso.Picasso

internal class CustomAdapter(
    private var dataList: List<Data>,
    private val callback: CustomAdapterCallback
) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_bulletin_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val imageSorce = dataList[position].owner.picture
        val title = dataList[position].owner.title
        val firstChip = dataList[position].tags.get(0)
        val secondChip = dataList[position].tags.get(1)
        val thirdChip = dataList[position].tags.get(2)
        val firstName = dataList[position].owner.firstName
        val lastName = dataList[position].owner.lastName
        val time = dataList[position].publishDate
        val like = dataList[position].likes

        Picasso.with(holder.itemView.context).load(imageSorce).into(holder.imageView)
        holder.name.text = firstName + " " + lastName
        holder.firstChip.text = firstChip
        holder.secondChip.text = secondChip
        holder.thirdChip.text = thirdChip
        holder.title.text = title
        holder.time.text = getTime(time)
        holder.likes.text = like.toString()

        holder.name.setOnClickListener {
            callback.onNewsItemClick(dataList[position])
        }
    }


    private fun getTime(time: String): String {
        val data = time
        val items = data.split("T".toRegex()).toTypedArray()
        val newTime: String = items.get(0) + "\n" + items.get(1)
        return newTime
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imageView: ImageView = view.findViewById(R.id.imgProfile)
        var title: TextView = view.findViewById(R.id.tvTitle)
        var firstChip: TextView = view.findViewById(R.id.firstChip)
        var secondChip: TextView = view.findViewById(R.id.secondChip)
        var thirdChip: TextView = view.findViewById(R.id.thirdChip)
        var time: TextView = view.findViewById(R.id.tvTime)
        var name: Button = view.findViewById(R.id.btnName)
        var likes: TextView = view.findViewById(R.id.tvLike)
    }

    interface CustomAdapterCallback {
        fun onNewsItemClick(item: Data)
    }
}


