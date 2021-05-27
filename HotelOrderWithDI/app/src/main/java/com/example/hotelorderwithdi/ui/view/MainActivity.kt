package com.example.hotelorderwithdi.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelorder.dataSource.model.OrderItem
import com.example.hotelorderwithdi.R
import com.example.hotelorderwithdi.dataSource.remoteDataSource.RestApiDataSourceImplementation
import com.example.hotelorderwithdi.viewModel.MainActivityViewModel
import com.example.hotelorderwithdi.viewModel.SampleViewModelFactory

class MainActivity : AppCompatActivity() {


    lateinit var mainActivityViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val restApiDataSourceImplementation = RestApiDataSourceImplementation()
        val factory = SampleViewModelFactory(restApiDataSourceImplementation)
        mainActivityViewModel =
            ViewModelProvider(this, factory).get(MainActivityViewModel::class.java)
        mainActivityViewModel.fetchOrderDetails()
        mainActivityViewModel.orderListLiveData.observe(this) {
            showOrderList(it)
        }
    }

    fun showOrderList(orderList: List<OrderItem>) {
        val recyclerView: RecyclerView = findViewById(R.id.orderRecyclerView)
        val orderAdapter = OrderAdapter(orderList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = orderAdapter
    }
}

