package com.example.basicmvvmwithdiwithgenericviewmodelfactory.di.hotelOrder

import com.example.basicmvvmwithdiwithgenericviewmodelfactory.dataSource.remoteDataSourceHotelOrder.RestApiDataSource
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.dataSource.remoteDataSourceHotelOrder.RestApiDataSourceImplementation
import dagger.Binds
import dagger.Module

@Module
abstract class RestApiDataSourceModule {

    @Binds
    abstract fun provideData(restApiDataSourceImplementation: RestApiDataSourceImplementation): RestApiDataSource

}