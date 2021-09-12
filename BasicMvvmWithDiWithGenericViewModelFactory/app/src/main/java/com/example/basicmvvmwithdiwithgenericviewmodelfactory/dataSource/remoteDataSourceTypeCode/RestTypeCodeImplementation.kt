package com.example.basicmvvmwithdiwithgenericviewmodelfactory.dataSource.remoteDataSourceTypeCode

import com.example.basicmvvmwithdiwithgenericviewmodelfactory.dataSource.model.typeCodeData.Posts
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.network.ApiInterface
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.network.RetrofitApiClientTypeCode
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class RestTypeCodeImplementation @Inject constructor() : RestTypeCode {
    private val apiInterface: ApiInterface =
        RetrofitApiClientTypeCode.getClientTypeCode()!!.create(ApiInterface::class.java)

    override fun fetchPostDetails(): Observable<Posts> {
        return apiInterface.getPost()
    }
}