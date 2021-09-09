package com.example.basicmvvmpattern.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basicmvvmpattern.R
import com.example.basicmvvmpattern.dataSource.model.OrderItem
import com.example.basicmvvmpattern.ui.adapter.OrderAdapter
import com.example.basicmvvmpattern.viewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //view model ke initialize korte hobe. Ebong tokhon i kora jabe jokhon view model e kono
        // constructor thakbe na
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.fetchOrderDetails()
        viewModel.orderListLiveData.observe(this, {
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