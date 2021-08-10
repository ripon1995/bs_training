package com.example.oshudhwala.medicine

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oshudhwala.base.BaseActivity
import com.example.oshudhwala.cart.CartActivity
import com.example.oshudhwala.databinding.ActivityMedicineBinding
import com.example.oshudhwala.dataSource.model.MedicineKey

class MedicineActivity() : BaseActivity(){

    private lateinit var medicineAdapter: MedicineAdapter

    private lateinit var binding: ActivityMedicineBinding

    private lateinit var viewModel: MedicineActivityViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MedicineActivityViewModel::class.java)

        viewModel.fetchMedicineList()
        viewModel.medicineListLiveData.observe(this,{
            prepareAdapter(it)
        })

    }

    private fun prepareAdapter(medicineList: ArrayList<MedicineKey>){
        val recyclerView = binding.rvMedicine
        medicineAdapter = MedicineAdapter(medicineList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = medicineAdapter
    }

}