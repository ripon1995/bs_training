package com.example.hotelorder.ui.features.order.view

import com.example.hotelorder.dataSource.model.OrderItem

interface OrderView {

    fun showOrderList(orderList: List<OrderItem>)
}