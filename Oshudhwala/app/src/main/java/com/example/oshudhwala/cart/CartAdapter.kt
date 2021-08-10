package com.example.oshudhwala.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.oshudhwala.R
import com.example.oshudhwala.dataSource.model.MedicineKey
import com.example.oshudhwala.dataSource.model.OrderList
import com.google.android.material.textview.MaterialTextView
import io.reactivex.Observable

class CartAdapter(private val orderDetailsList: ArrayList<MedicineKey>,val listener:TotalCalculation) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    private val detail: ArrayList<OrderList> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartAdapter.ViewHolder, position: Int) {

        var quantity = 1
        val price = orderDetailsList[position].medicinePrice
        holder.medicineName.text = orderDetailsList[position].medicineName
        holder.medicinePrice.text = price.toString()
        holder.medicineQuantity.text = quantity.toString()

        var data = OrderList(
            orderDetailsList[position].medicineName,
            orderDetailsList[position].medicinePrice,
            quantity
        );
        detail.add(data)
        calculateTotal()

        holder.addOne.setOnClickListener {
            quantity++
            val unitPrice = quantity * price
            holder.medicineQuantity.text = quantity.toString()
            holder.medicinePrice.text = unitPrice.toString()
            data = OrderList(
                orderDetailsList[position].medicineName,
                orderDetailsList[position].medicinePrice,
                quantity
            );

            updateOrderList(quantity, data.medicineName)
        }
        holder.minusOne.setOnClickListener {
            quantity--
            if (quantity < 1) quantity = 1;
            val unitPrice = quantity * price
            holder.medicineQuantity.text = quantity.toString()
            holder.medicinePrice.text = unitPrice.toString()
            data = OrderList(
                orderDetailsList[position].medicineName,
                orderDetailsList[position].medicinePrice,
                quantity
            )

            updateOrderList(quantity, data.medicineName)
        }

    }

    override fun getItemCount(): Int {
        return orderDetailsList.size
    }

    private fun calculateTotal() {
        println("Orderlist: size: " + detail.size)
        var total=0
        for (i in detail) {
            //println("Medicine name: " + i.medicineName + "   Medicine price: " + i.medicinePrice + "   Medicine quantity: " + i.medicineQuantity)
            total+=(i.medicinePrice*i.medicineQuantity).toInt()
        }
        val data = Observable.fromArray(total)
        listener.getTotalCalculation(data)
    }

    private fun updateOrderList(quanity: Int, name: String) {
        for (i in detail) {
            if (i.medicineName == name) {
                i.medicineQuantity = quanity;
            }
        }
        calculateTotal()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val medicineName: MaterialTextView = view.findViewById(R.id.tvElementName)
        val medicinePrice: MaterialTextView = view.findViewById(R.id.tvElementPrice)
        val medicineQuantity: MaterialTextView = view.findViewById(R.id.tvElementQuantity)
        val addOne: AppCompatImageView = view.findViewById(R.id.btnAddOne)
        val minusOne: AppCompatImageView = view.findViewById(R.id.btnMinusOne)

    }

    interface TotalCalculation{
        fun getTotalCalculation(cost:Observable<Int>)
    }

}