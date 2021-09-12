package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di

import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.remoteDataSourceTypeCode.RestTypeCode
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.remoteDataSourceTypeCode.RestTypeCodeImplementation
import dagger.Binds
import dagger.Module

@Module
abstract class RestApiTypeCodeModule {

    @Binds
    abstract fun provideData(restTypeCodeImplementation: RestTypeCodeImplementation): RestTypeCode
}