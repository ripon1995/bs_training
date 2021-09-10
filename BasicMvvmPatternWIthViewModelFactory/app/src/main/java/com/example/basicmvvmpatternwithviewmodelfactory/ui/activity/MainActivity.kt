package com.example.basicmvvmpatternwithviewmodelfactory.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basicmvvmpatternwithviewmodelfactory.R
import com.example.basicmvvmpatternwithviewmodelfactory.dataSource.model.OrderItem
import com.example.basicmvvmpatternwithviewmodelfactory.dataSource.remoteDataSource.RestApiDataSourceImplementation
import com.example.basicmvvmpatternwithviewmodelfactory.ui.adapter.OrderAdapter
import com.example.basicmvvmpatternwithviewmodelfactory.viewModel.MainActivityViewModel
import com.example.basicmvvmpatternwithviewmodelfactory.viewModel.ViewModelFactory
//When we have constructor parameter in viewModel we need a viewModelFactory to initialize viewModel
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val restApiDataSourceImplementation = RestApiDataSourceImplementation()
        //this is the required factory
        val factory =
            ViewModelFactory(restApiDataSourceImplementation = restApiDataSourceImplementation)
        //this is the process to initialize viewModel when we have constructor parameter in viewModel
        viewModel = ViewModelProvider(this, factory).get(MainActivityViewModel::class.java)

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