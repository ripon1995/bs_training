package com.example.oshudhwala.dataSource

import android.content.SharedPreferences
import com.example.oshudhwala.dataSource.model.Medicine
import com.example.oshudhwala.dataSource.model.MedicineKey
import com.example.oshudhwala.dataSource.network.ApiInterface
import com.example.oshudhwala.dataSource.network.RetrofitClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.orhanobut.logger.Logger
import io.reactivex.Observable

class RestApiDataSourceImplementation : RestApiDataSource {

    private val apiInterface: ApiInterface =
        RetrofitClient.getId()!!.create(ApiInterface::class.java)

    override fun getMedicine(listener: LoadStatus) {
        val medicineElement = ArrayList<MedicineKey>()
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("medicine")

        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (ds in snapshot.children) {
                    val med = ds.getValue(MedicineKey::class.java)
                    if (med != null) {
                        medicineElement.add(med)
                    }
                }
                val test = Observable.fromArray(medicineElement)
                listener.loadCompleted(test)
            }

            override fun onCancelled(error: DatabaseError) {
                println("Error: $error")
            }
        })

    }

    override fun orderedMedicine(listener: OrderDetails) {
        val medicineElement = ArrayList<MedicineKey>()
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("order")

        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (ds in snapshot.children) {
                    val med = ds.getValue(MedicineKey::class.java)
                    if (med != null) {
                        medicineElement.add(med)
                    }
                }
                val test = Observable.fromArray(medicineElement)
                listener.loadOrderDetails(test)
            }

            override fun onCancelled(error: DatabaseError) {
                println("Error: $error")
            }
        })
    }

    interface OrderDetails{
        fun loadOrderDetails(medicineList: Observable<ArrayList<MedicineKey>>)
    }

    interface LoadStatus {
        fun loadCompleted(medicineList: Observable<ArrayList<MedicineKey>>)
    }
}