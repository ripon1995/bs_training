package com.example.oshudhwala.cart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oshudhwala.R
import com.example.oshudhwala.base.BaseActivity
import com.example.oshudhwala.dataSource.model.MedicineKey
import com.example.oshudhwala.databinding.ActivityCartBinding
import com.example.oshudhwala.medicine.MedicineActivityViewModel
import com.example.oshudhwala.medicine.MedicineAdapter

class CartActivity : BaseActivity() {

    private lateinit var viewModel: CartViewModel
    private lateinit var binding: ActivityCartBinding
    private lateinit var cartAdapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        viewModel.fetchOrderedList()
        viewModel.medicineOrderedList.observe(this,{
            prepareAdapter(it)
        })

        viewModel.totalCost.observe(this,{
            println("TOTAL COST: $it")
        })

    }


    private fun printData(orderedList: ArrayList<MedicineKey>) {
        for(i in orderedList){
            println("Data: ${i.medicineName}")
            println("Data: ${i.medicinePrice}")
        }
    }

    private fun prepareAdapter(medicineList: ArrayList<MedicineKey>){
        val recyclerView = binding.rvCart
        cartAdapter = CartAdapter(medicineList,this.viewModel)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = cartAdapter
    }

}