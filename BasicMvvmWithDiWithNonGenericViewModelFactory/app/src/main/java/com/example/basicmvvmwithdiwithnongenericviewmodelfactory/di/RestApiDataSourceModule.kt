package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di

import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.remoteDataSourceHotelOrder.RestApiDataSource
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.dataSource.remoteDataSourceHotelOrder.RestApiDataSourceImplementation
import dagger.Binds
import dagger.Module

@Module
abstract class RestApiDataSourceModule {

    @Binds
    abstract fun provideData(restApiDataSourceImplementation: RestApiDataSourceImplementation): RestApiDataSource

}