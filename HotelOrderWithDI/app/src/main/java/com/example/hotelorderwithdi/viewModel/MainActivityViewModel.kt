package com.example.hotelorderwithdi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hotelorder.dataSource.model.Order
import com.example.hotelorder.dataSource.model.OrderItem
import com.example.hotelorderwithdi.dataSource.remoteDataSource.RestApiDataSource
import com.example.hotelorderwithdi.dataSource.remoteDataSource.RestApiDataSourceImplementation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel(): ViewModel() {
    private var restApiDataSource: RestApiDataSource = RestApiDataSourceImplementation()
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
}