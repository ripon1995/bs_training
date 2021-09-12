package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.R
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.model.typeCodeData.SinglePost

class PostAdapter(private var postList: List<SinglePost>):RecyclerView.Adapter<PostAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.typecode_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostAdapter.MyViewHolder, position: Int) {
        holder.tvUserId.text = postList[position].userId.toString()
        holder.tvPostId.text = postList[position].id.toString()
        holder.tvTitle.text = postList[position].title
    }


    override fun getItemCount(): Int {
        return postList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvUserId = view.findViewById<TextView>(R.id.tvUserId)
        var tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        var tvPostId = view.findViewById<TextView>(R.id.tvPostId)
    }


}