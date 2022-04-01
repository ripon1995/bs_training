package com.example.treeplantationfrontend.network

import com.example.treeplantationfrontend.datasource.model.responseBody.Token
import com.example.treeplantationfrontend.datasource.model.requestBody.SignUpRequestBody
import com.example.treeplantationfrontend.datasource.model.requestBody.UserRequestBody
import com.example.treeplantationfrontend.datasource.model.responseBody.CustomerSignUpResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiInterface {
    @POST("auth/jwt/create/")
    fun getAccessToken(@Body userRequestBody: UserRequestBody): Observable<Response<Token>>

    @POST("customers/signup/")
    fun signupCustomer(@Body requestBody: SignUpRequestBody): Observable<Response<CustomerSignUpResponse>>
}