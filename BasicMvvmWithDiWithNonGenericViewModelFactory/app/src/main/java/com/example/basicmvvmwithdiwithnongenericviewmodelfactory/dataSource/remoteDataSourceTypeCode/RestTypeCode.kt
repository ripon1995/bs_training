package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.remoteDataSourceTypeCode

import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.model.typeCodeData.Posts
import io.reactivex.rxjava3.core.Observable

interface RestTypeCode {
    fun fetchPostDetails(): Observable<Posts>
}