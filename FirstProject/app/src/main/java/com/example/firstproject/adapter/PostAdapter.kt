package com.example.firstproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R
import com.example.firstproject.model.DataX
import com.squareup.picasso.Picasso

internal class PostAdapter(
    private var dataList: List<DataX>,
    private var imageSource: String,
    private var name: String
) : RecyclerView.Adapter<PostAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.posts, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.MyViewHolder, position: Int) {

        val postImageSource: String = dataList[position].image
        Picasso.with(holder.itemView.context).load(postImageSource).into(holder.imageView)
        Picasso.with(holder.itemView.context).load(imageSource).into(holder.image)
        holder.profileName.text = name
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView = view.findViewById(R.id.postImages)
        var image: ImageView = view.findViewById(R.id.imagePost)
        var profileName: TextView = view.findViewById(R.id.postDetailsLabel)
    }


}