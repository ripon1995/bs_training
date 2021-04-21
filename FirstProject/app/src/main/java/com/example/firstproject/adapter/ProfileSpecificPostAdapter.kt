package com.example.firstproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R
import com.example.firstproject.dataSource.model.ProfilePost
import com.squareup.picasso.Picasso

internal class ProfileSpecificPostAdapter(
    private var dataList: List<ProfilePost>,
    private var imageSource: String,
    private var name: String
) : RecyclerView.Adapter<ProfileSpecificPostAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileSpecificPostAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.profile_shared_post_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileSpecificPostAdapter.MyViewHolder, position: Int) {

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