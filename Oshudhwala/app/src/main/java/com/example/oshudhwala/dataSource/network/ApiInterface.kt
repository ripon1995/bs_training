package com.example.oshudhwala.dataSource.network


import com.example.oshudhwala.dataSource.model.Medicine
import com.example.oshudhwala.dataSource.model.MedicineKey
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {

    @GET("medicine")
    fun getMedicineList() : Observable<ArrayList<Medicine>>
}