package com.example.hotelorder.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelorder.R
import com.example.hotelorder.dataSource.RestApiDataSource
import com.example.hotelorder.dataSource.RestApiDataSourceImplementation
import com.example.hotelorder.dataSource.model.OrderItem
import com.example.hotelorder.ui.adapter.OrderAdapter


class MainActivity : AppCompatActivity(), OrderView {

    private lateinit var restApiDataSourceImplementation: RestApiDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        restApiDataSourceImplementation = RestApiDataSourceImplementation()
//        orderPresenterImplementation =
//            OrderPresenterImplementation(restApiDataSourceImplementation, this)
//        orderPresenterImplementation.fetchOrderDetails()
    }


    override fun showOrderList(orderList: List<OrderItem>) {
        val recyclerView: RecyclerView = findViewById(R.id.orderRecyclerView)
        val orderAdapter = OrderAdapter(orderList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = orderAdapter
    }
}