package com.example.hotelorder.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelorder.R
import com.example.hotelorder.dataSource.model.OrderItem
import java.text.SimpleDateFormat
import java.util.*


class OrderAdapter(private var orderList: List<OrderItem>) :
    RecyclerView.Adapter<OrderAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderAdapter.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.order_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OrderAdapter.MyViewHolder, position: Int) {
        holder.tvOrderIdValue.text = orderList[position].Order_ID.toString()
        holder.tvOrderCrustValue.text = orderList[position].Crust
        holder.tvOrderFlavorValue.text = orderList[position].Flavor
        holder.tvOrderSize.text = orderList[position].Size
        holder.tvOrderTableValue.text = orderList[position].Table_No.toString()
        holder.tvOrderTimeValue.text = getTime(orderList[position].Timestamp)
        holder.tvOrderDateValue.text = getDate(orderList[position].Timestamp)
    }

    private fun getTime(time: String): String {
        val data = time
        val parsingFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ENGLISH)
        val date = parsingFormatter.parse(data)
        val dateFormatter = SimpleDateFormat("HH:mm:ss", Locale.ENGLISH)
        return dateFormatter.format(date)
    }

    private fun getDate(time: String): String {
        val data = time
        val parsingFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ENGLISH)
        val date = parsingFormatter.parse(data)
        val dateFormatter = SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH)
        return dateFormatter.format(date)
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var tvOrderIdValue = view.findViewById<TextView>(R.id.tvOrderIdValue)
        var tvOrderCrustValue = view.findViewById<TextView>(R.id.tvOrderCrustValue)
        var tvOrderFlavorValue = view.findViewById<TextView>(R.id.tvOrderFlavourValue)
        var tvOrderSize = view.findViewById<TextView>(R.id.tvOrderSizeValue)
        var tvOrderTableValue = view.findViewById<TextView>(R.id.tvOrderTableValue)
        var tvOrderTimeValue = view.findViewById<TextView>(R.id.tvOrderTimeValue)
        var tvOrderDateValue = view.findViewById<TextView>(R.id.tvOrderDateValue)
    }
}