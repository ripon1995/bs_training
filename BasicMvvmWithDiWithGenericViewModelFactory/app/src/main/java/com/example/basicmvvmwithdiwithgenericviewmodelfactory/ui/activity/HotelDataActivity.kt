package com.example.basicmvvmwithdiwithgenericviewmodelfactory.ui.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.R
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.dataSource.model.hotelData.OrderItem
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.ui.adapter.OrderAdapter
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.viewModel.hotelOrder.HotelDataActivityViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class HotelDataActivity : DaggerAppCompatActivity() {
    lateinit var viewModel: HotelDataActivityViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_data)

        viewModel =
            ViewModelProvider(this, viewModelFactory).get(HotelDataActivityViewModel::class.java)
        viewModel.fetchOrderDetails()
        viewModel.orderListLiveData.observe(this, {
            showOrderList(it)
        })

    }

    private fun showOrderList(orderList: List<OrderItem>) {
        val recyclerView: RecyclerView = findViewById(R.id.orderRecyclerView)
        val orderAdapter = OrderAdapter(orderList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = orderAdapter
    }
}