package com.example.oshudhwala.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.oshudhwala.dataSource.RestApiDataSource
import com.example.oshudhwala.dataSource.RestApiDataSourceImplementation
import com.example.oshudhwala.dataSource.model.MedicineKey
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CartViewModel:ViewModel() ,RestApiDataSourceImplementation.OrderDetails,CartAdapter.TotalCalculation {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var restApiDataSource = RestApiDataSourceImplementation()
    var medicineOrderedList : MutableLiveData<ArrayList<MedicineKey>> = MutableLiveData()
    var totalCost : MutableLiveData<Int> = MutableLiveData()


    fun fetchOrderedList(){
        restApiDataSource.orderedMedicine(this)
    }


    override fun loadOrderDetails(medicineList: Observable<ArrayList<MedicineKey>>) {
        compositeDisposable.add(medicineList
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                medicineOrderedList.value = it
            })
    }

    override fun getTotalCalculation(cost: Observable<Int>) {
        compositeDisposable.add(cost
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                totalCost.value = it
            })

    }
}