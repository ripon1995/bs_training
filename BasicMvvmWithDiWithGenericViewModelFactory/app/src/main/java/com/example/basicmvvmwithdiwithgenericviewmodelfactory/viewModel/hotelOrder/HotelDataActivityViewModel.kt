package com.example.basicmvvmwithdiwithgenericviewmodelfactory.viewModel.hotelOrder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.dataSource.model.hotelData.Order
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.dataSource.remoteDataSourceHotelOrder.RestApiDataSourceImplementation
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class HotelDataActivityViewModel @Inject constructor(private val restApiDataSource: RestApiDataSourceImplementation) :
    ViewModel() {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    var orderListLiveData: MutableLiveData<Order> = MutableLiveData<Order>()

    fun fetchOrderDetails() {

        compositeDisposable.add(
            restApiDataSource.fetchOrderDetails()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    orderListLiveData.value = it
                }
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}