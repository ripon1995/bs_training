package com.example.treeplantationfrontend.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.treeplantationfrontend.datasource.model.requestBody.AuthenticationRequest
import com.example.treeplantationfrontend.datasource.model.requestBody.SignUpRequestBody
import com.example.treeplantationfrontend.datasource.model.requestBody.UserRequestBody
import com.example.treeplantationfrontend.datasource.model.responseBody.CustomerSignUpResponse
import com.example.treeplantationfrontend.datasource.remoteDataSource.RestDataSource
import com.example.treeplantationfrontend.datasource.remoteDataSource.RestDataSourceImpl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class AuthViewModel : ViewModel() {
    private val restApiDataSource: RestDataSource = RestDataSourceImpl()
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    val signUpConfirmation = MutableLiveData<CustomerSignUpResponse>()
    val authenticationConfirmation = MutableLiveData<String>()

    override fun onCleared() {
        compositeDisposable.clear()
    }

    fun fetchAccessToken(requestBody: UserRequestBody) {
        compositeDisposable.add(
            restApiDataSource.getAccessToken(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    println("refresh=========>${it.refresh}")
                    println("access==========>${it.access}")
                }, {
                    println("${it.stackTrace} ")
                })
        )
    }

    fun signUpCustomers(username: String, email: String, password: String) {
        val requestBody = SignUpRequestBody(
            username = username,
            name = "--------",
            email = email,
            password = password,
            phone = "--------"
        )
        compositeDisposable.add(
            restApiDataSource.signUpUser(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    signUpConfirmation.value = it
                }, {
                    println("${it.stackTrace}")
                })
        )

    }

    fun authenticateCustomer(username: String, email: String, password: String) {
        val requestBody = AuthenticationRequest(
            username = username,
            email = email,
            password = password
        )
        compositeDisposable.add(
            restApiDataSource.authenticateUser(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    authenticationConfirmation.value = it.username
                },
                    {
                        println("${it.printStackTrace()}")
                    }
                )
        )
    }
}