package com.example.hotelorderwithhilt.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelorderwithhilt.R
import com.example.hotelorderwithhilt.dataSource.model.OrderItem
import com.example.hotelorderwithhilt.ui.adapter.OrderAdapter
import com.example.hotelorderwithhilt.viewModel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

     private val mainActivityViewModel:MainActivityViewModel by viewModels()


    override

    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel.fetchOrderDetails()
        mainActivityViewModel.orderListLiveData.observe(this) {
            showOrderList(it)
        }
    }

    private fun showOrderList(orderList: List<OrderItem>) {
        val recyclerView: RecyclerView = findViewById(R.id.orderRecyclerView)
        val orderAdapter = OrderAdapter(orderList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = orderAdapter
    }
}