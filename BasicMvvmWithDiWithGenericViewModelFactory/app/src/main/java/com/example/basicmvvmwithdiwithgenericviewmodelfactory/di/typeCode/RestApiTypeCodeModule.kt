package com.example.basicmvvmwithdiwithgenericviewmodelfactory.di.typeCode

import com.example.basicmvvmwithdiwithgenericviewmodelfactory.dataSource.remoteDataSourceTypeCode.RestTypeCode
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.dataSource.remoteDataSourceTypeCode.RestTypeCodeImplementation
import dagger.Binds
import dagger.Module

@Module
abstract class RestApiTypeCodeModule {

    @Binds
    abstract fun provideData(restTypeCodeImplementation: RestTypeCodeImplementation): RestTypeCode
}