package com.example.hotelorderwithdi.di.mainActivity

import com.example.hotelorderwithdi.dataSource.remoteDataSource.RestApiDataSource
import com.example.hotelorderwithdi.dataSource.remoteDataSource.RestApiDataSourceImplementation
import dagger.Binds
import dagger.Module

@Module
abstract class RestApiDataSourceModule {

    @Binds
    abstract fun provideData(restApiDataSourceImplementation: RestApiDataSourceImplementation):RestApiDataSource

}