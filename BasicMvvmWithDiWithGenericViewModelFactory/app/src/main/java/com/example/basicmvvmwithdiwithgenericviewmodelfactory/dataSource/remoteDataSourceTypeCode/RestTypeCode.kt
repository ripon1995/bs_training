package com.example.basicmvvmwithdiwithgenericviewmodelfactory.dataSource.remoteDataSourceTypeCode

import com.example.basicmvvmwithdiwithgenericviewmodelfactory.dataSource.model.typeCodeData.Posts
import io.reactivex.rxjava3.core.Observable

interface RestTypeCode {
    fun fetchPostDetails(): Observable<Posts>
}