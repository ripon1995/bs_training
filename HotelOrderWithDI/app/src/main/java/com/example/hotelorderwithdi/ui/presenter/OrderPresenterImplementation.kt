package com.example.hotelorder.ui.features.order.presenter

import com.example.hotelorder.dataSource.RestApiDataSource
import com.example.hotelorder.dataSource.model.Order
import com.example.hotelorder.dataSource.model.OrderItem
import com.example.hotelorder.ui.features.order.view.OrderView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrderPresenterImplementation(
    private var restApiDataSource: RestApiDataSource,
    private var orderView: OrderView
) : OrderPresenter {
    override fun fetchOrderDetails() {
        val orderList = mutableListOf<OrderItem>()
        restApiDataSource.fetchOrderDetails().enqueue(object : Callback<Order?> {
            override fun onResponse(call: Call<Order?>, response: Response<Order?>) {
                val myResponse = response.body()
                val list: List<OrderItem>
                if (response.code() == 200 && myResponse != null) {
                    list = myResponse
                    orderList.addAll(list)
                    orderView.showOrderList(orderList)
                }
            }

            override fun onFailure(call: Call<Order?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}