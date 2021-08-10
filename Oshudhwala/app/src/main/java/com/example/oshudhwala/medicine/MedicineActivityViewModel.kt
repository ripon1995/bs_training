package com.example.oshudhwala.medicine

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.oshudhwala.dataSource.RestApiDataSourceImplementation
import com.example.oshudhwala.dataSource.model.MedicineKey
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class MedicineActivityViewModel : ViewModel(), RestApiDataSourceImplementation.LoadStatus{

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var restApiDataSource = RestApiDataSourceImplementation()

    var medicineListLiveData: MutableLiveData<ArrayList<MedicineKey>> = MutableLiveData()

    fun fetchMedicineList() {
        restApiDataSource.getMedicine(this)
    }

    override fun loadCompleted(medicineList: Observable<ArrayList<MedicineKey>>) {

        compositeDisposable.add(medicineList
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                medicineListLiveData.value = it
            }
        )
    }

}