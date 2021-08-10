package com.example.oshudhwala.medicine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.oshudhwala.R
import com.example.oshudhwala.dataSource.model.MedicineKey
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import com.google.firebase.database.FirebaseDatabase

class MedicineAdapter(private val medicineList: ArrayList<MedicineKey>) :
    RecyclerView.Adapter<MedicineAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineAdapter.ViewHolder {
        val view =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.medicine_per_item, parent, false);
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicineAdapter.ViewHolder, position: Int) {

        val dataList = ArrayList<Int>()
        holder.medicineName.text = medicineList[position].medicineName
        holder.medicinePrice.text = medicineList[position].medicinePrice.toString()
        holder.btnAdd.setOnClickListener {

            Toast.makeText(it.context, "Item Added", Toast.LENGTH_SHORT).show()
            if (!dataList.contains(position)) {
                val reference = FirebaseDatabase.getInstance().reference
                val postReference = reference.child("order")
                val newPostref = postReference.push()
                newPostref.setValue(medicineList[position]);
                dataList.add(position)
            }

        }
    }

    override fun getItemCount(): Int {
        return medicineList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val medicineName = view.findViewById<MaterialTextView>(R.id.tvMedicineName)
        val medicinePrice = view.findViewById<MaterialTextView>(R.id.tvMedicinePrice)
        val btnAdd = view.findViewById<MaterialButton>(R.id.btnAdd)
    }

}