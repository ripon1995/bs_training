package com.example.basicmvvmpattern.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basicmvvmpattern.dataSource.model.Order
import com.example.basicmvvmpattern.dataSource.remoteDataSource.RestApiDataSource
import com.example.basicmvvmpattern.dataSource.remoteDataSource.RestApiDataSourceImplementation
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

//View model e kono constructor parameter thakte parbe na.
//Rest api data source ke viewmodel er moddhe initilize kore nite hobe
class MainActivityViewModel : ViewModel() {

    private val restApiDataSource: RestApiDataSource = RestApiDataSourceImplementation()
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