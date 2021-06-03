package com.example.hotelorderwithhilt.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hotelorderwithhilt.dataSource.model.Order
import com.example.hotelorderwithhilt.dataSource.remoteDataSource.RestApiDataSourceImplementation
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val restApiDataSource: RestApiDataSourceImplementation) :
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