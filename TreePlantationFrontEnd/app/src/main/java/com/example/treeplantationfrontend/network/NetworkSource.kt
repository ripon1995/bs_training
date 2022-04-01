package com.example.treeplantationfrontend.network

import com.example.treeplantationfrontend.datasource.model.requestBody.SignUpRequestBody
import com.example.treeplantationfrontend.datasource.model.requestBody.UserRequestBody
import com.example.treeplantationfrontend.datasource.model.responseBody.CustomerSignUpResponse
import com.example.treeplantationfrontend.datasource.model.responseBody.Token
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response

interface NetworkSource {
    fun getAccessToken(requestBody: UserRequestBody): Observable<Response<Token>>

    fun signUpCustomer(requestBody: SignUpRequestBody): Observable<Response<CustomerSignUpResponse>>
}