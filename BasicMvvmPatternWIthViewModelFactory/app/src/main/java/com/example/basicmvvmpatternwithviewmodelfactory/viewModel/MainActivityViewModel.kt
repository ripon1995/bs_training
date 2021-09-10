package com.example.basicmvvmpatternwithviewmodelfactory.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basicmvvmpatternwithviewmodelfactory.dataSource.model.Order
import com.example.basicmvvmpatternwithviewmodelfactory.dataSource.remoteDataSource.RestApiDataSourceImplementation
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
//Here viewModel has a constructor. To work with this type of viewModel we need a ViewModel factory class
// Here ViewModelFactory is the factory class
class MainActivityViewModel(private val restApiDataSource: RestApiDataSourceImplementation) :
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