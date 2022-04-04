package com.example.treeplantationfrontend.datasource.remoteDataSource

import com.example.treeplantationfrontend.datasource.model.requestBody.AuthenticationRequest
import com.example.treeplantationfrontend.datasource.model.requestBody.SignUpRequestBody
import com.example.treeplantationfrontend.datasource.model.requestBody.UserRequestBody
import com.example.treeplantationfrontend.datasource.model.responseBody.AuthenticationResponse
import com.example.treeplantationfrontend.datasource.model.responseBody.CustomerSignUpResponse
import com.example.treeplantationfrontend.datasource.model.responseBody.Token
import io.reactivex.rxjava3.core.Observable

interface RestDataSource {
    fun getAccessToken(requestBody: UserRequestBody): Observable<Token>
    fun signUpUser(requestBody: SignUpRequestBody): Observable<CustomerSignUpResponse>
    fun authenticateUser(requestBody: AuthenticationRequest): Observable<AuthenticationResponse>
}