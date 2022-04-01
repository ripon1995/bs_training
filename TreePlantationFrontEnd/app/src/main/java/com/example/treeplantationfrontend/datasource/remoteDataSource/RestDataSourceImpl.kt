package com.example.treeplantationfrontend.datasource.remoteDataSource

import com.example.treeplantationfrontend.datasource.model.requestBody.SignUpRequestBody
import com.example.treeplantationfrontend.datasource.model.requestBody.UserRequestBody
import com.example.treeplantationfrontend.datasource.model.responseBody.CustomerSignUpResponse
import com.example.treeplantationfrontend.datasource.model.responseBody.Token
import com.example.treeplantationfrontend.network.NetworkSourceImpl
import io.reactivex.rxjava3.core.Observable

class RestDataSourceImpl : RestDataSource {
    private val networkSource = NetworkSourceImpl()
    override fun getAccessToken(requestBody: UserRequestBody): Observable<Token> {
        return networkSource.getAccessToken(requestBody).map {
            it.body()!!
        }
    }

    override fun signUpUser(requestBody: SignUpRequestBody): Observable<CustomerSignUpResponse> {
        return networkSource.signUpCustomer(requestBody).map {
            it.body()!!
        }
    }
}