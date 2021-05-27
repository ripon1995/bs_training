package com.example.hotelorderwithdi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hotelorder.dataSource.model.Order
import com.example.hotelorderwithdi.dataSource.remoteDataSource.RestApiDataSourceImplementation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivityViewModel(private val restApiDataSource: RestApiDataSourceImplementation) :
    ViewModel() {
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    var orderListLiveData: MutableLiveData<Order> = MutableLiveData<Order>()
    fun fetchOrderDetails() {

        compositeDisposable.add(
            restApiDataSource.fetchOrderDetails()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    orderListLiveData.value = it
                })
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}