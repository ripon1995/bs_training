package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.remoteDataSourceTypeCode

import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.model.typeCodeData.Posts
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.network.ApiInterface
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.network.RetrofitApiClientTypeCode
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class RestTypeCodeImplementation @Inject constructor() : RestTypeCode {
    private val apiInterface: ApiInterface =
        RetrofitApiClientTypeCode.getClientTypeCode()!!.create(ApiInterface::class.java)

    override fun fetchPostDetails(): Observable<Posts> {
        return apiInterface.getPost()
    }
}