package com.example.hotelorder.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelorder.R
import com.example.hotelorder.dataSource.RestApiDataSource
import com.example.hotelorder.dataSource.RestApiDataSourceImplementation
import com.example.hotelorder.dataSource.model.OrderItem
import com.example.hotelorder.ui.adapter.OrderAdapter
import com.example.hotelorder.viewModel.MainActivityViewModel
import com.example.hotelorder.viewModel.ViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val restApiDataSourceImplementation=RestApiDataSourceImplementation()
        val factory = ViewModelFactory(restApiDataSourceImplementation = restApiDataSourceImplementation)
        viewModel = ViewModelProvider(this,factory).get(MainActivityViewModel::class.java)
        viewModel.fetchOrderDetails()
        viewModel.orderListLiveData.observe(this,{
            showOrderList(it)
        })
    }

     fun showOrderList(orderList: List<OrderItem>) {
        val recyclerView: RecyclerView = findViewById(R.id.orderRecyclerView)
        val orderAdapter = OrderAdapter(orderList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = orderAdapter
    }
}