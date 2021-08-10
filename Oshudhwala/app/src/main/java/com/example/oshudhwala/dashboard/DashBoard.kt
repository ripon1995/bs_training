package com.example.oshudhwala.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.core.view.isVisible
import com.example.oshudhwala.R
import com.example.oshudhwala.base.BaseActivity
import com.example.oshudhwala.cart.CartActivity
import com.example.oshudhwala.databinding.ActivityDashboardBinding
import com.example.oshudhwala.medicine.MedicineActivity
import com.example.oshudhwala.dataSource.model.Medicine
import com.google.firebase.database.FirebaseDatabase
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

class DashBoard : BaseActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //addMedicineToDatabase()

        binding.downArrow.setOnClickListener {
            if (binding.hiddenLayout.isVisible) {
                binding.hiddenLayout.visibility = GONE;
            } else {
                binding.hiddenLayout.visibility = VISIBLE
            }
        }

        binding.cvMedicine.setOnClickListener {
            medicine();
        }

        binding.fabCart.setOnClickListener {
            goToCart()
        }


        binding.bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.itemDetails -> {
                    // Handle search icon press
                    println("Search clicked")
                    true
                }
                R.id.itemProfile -> {
                    // Handle more item (inside overflow menu) press
                    println("more clicked")
                    true
                }
                else -> false
            }
        }

    }


    private fun medicine(){
        val intent = Intent(this,MedicineActivity::class.java)
        startActivity(intent)
    }

    private fun goToCart(){
        val intent = Intent(this,CartActivity::class.java)
        startActivity(intent)
    }

    private fun addMedicineToDatabase(){

        val reference =  FirebaseDatabase.getInstance().reference
        val postReference = reference.child("medicine")

        var newPostref = postReference.push()
        newPostref.setValue(Medicine("Thyrox",100));

        newPostref = postReference.push()
        newPostref.setValue(Medicine("Zeltas",120));

        newPostref = postReference.push()
        newPostref.setValue(Medicine("Acifix",10));

        newPostref = postReference.push()
        newPostref.setValue(Medicine("Cord liver oil",10));

        newPostref = postReference.push()
        newPostref.setValue(Medicine("Napa",10));

        newPostref = postReference.push()
        newPostref.setValue(Medicine("Perkirol",10));

        newPostref = postReference.push()
        newPostref.setValue(Medicine("Zepiron",10));

        newPostref = postReference.push()
        newPostref.setValue(Medicine("Bicozin",10));

        newPostref = postReference.push()
        newPostref.setValue(Medicine("AB1",10));

        newPostref = postReference.push()
        newPostref.setValue(Medicine("Coralcal-d",10));

        newPostref = postReference.push()
        newPostref.setValue(Medicine("Bizoran",10));

        newPostref = postReference.push()
        newPostref.setValue(Medicine("Alprax",10));

        newPostref = postReference.push()
        newPostref.setValue(Medicine("Histacin",10));

        newPostref = postReference.push()
        newPostref.setValue(Medicine("Napa-extend",10));


        Logger.addLogAdapter(AndroidLogAdapter())
        Logger.d(newPostref.key)

    }

}