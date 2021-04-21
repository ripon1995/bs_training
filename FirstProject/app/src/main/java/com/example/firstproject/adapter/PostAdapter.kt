package com.example.firstproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R
import com.example.firstproject.model.Profile
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

internal class PostAdapter(
    private var profileList: List<Profile>,
    private val callback: CustomAdapterCallback
) :
    RecyclerView.Adapter<PostAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val imageSorce = profileList[position].user.picture
        val title = profileList[position].user.title
        val firstName = profileList[position].user.firstName
        val lastName = profileList[position].user.lastName
        val time = profileList[position].publishDate
        val like = profileList[position].likes

        //dynamically adding chips in chipGroup

        for (i in profileList[position].tags) {
            val chip: Chip = Chip(holder.itemView.context)
            chip.text = i
            // chip.chipBackgroundColor= ColorStateList.valueOf(Color.BLUE)
            holder.chipGroup.addView(chip)
        }
        Picasso.with(holder.itemView.context).load(imageSorce).into(holder.imageProfile)
        holder.btnName.text = firstName + " " + lastName
        holder.tvTitle.text = title
        holder.tvTime.text = getTime(time)
        holder.tvLike.text = like.toString()

        holder.btnName.setOnClickListener {
            callback.onNewsItemClick(profileList[position])
        }
    }


    private fun getTime(time: String): String {
        val data = time.replace("Z", "+0000")
        val parsingFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH)
        val date = parsingFormatter.parse(data)
        val dateFormatter = SimpleDateFormat("yyyy/MM/dd\nHH:mm:ss", Locale.ENGLISH)
        return dateFormatter.format(date)

    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imageProfile: ImageView = view.findViewById(R.id.imageViewProfile)
        var tvTitle: TextView = view.findViewById(R.id.tvProfileTitle)
        var tvTime: TextView = view.findViewById(R.id.tvPostTime)
        var btnName: Button = view.findViewById(R.id.btnName)
        var tvLike: TextView = view.findViewById(R.id.tvLikesCount)
        var chipGroup: ChipGroup = view.findViewById(R.id.chipGroup)
    }

    interface CustomAdapterCallback {
        fun onNewsItemClick(item: Profile)
    }
}
