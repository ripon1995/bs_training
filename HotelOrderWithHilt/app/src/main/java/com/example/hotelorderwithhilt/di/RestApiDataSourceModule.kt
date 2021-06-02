package com.example.hotelorderwithhilt.di

import com.example.hotelorderwithhilt.dataSource.remoteDataSource.RestApiDataSource
import com.example.hotelorderwithhilt.dataSource.remoteDataSource.RestApiDataSourceImplementation
import dagger.Binds
import dagger.Module

@Module
abstract class RestApiDataSourceModule {

    @Binds
    abstract fun provideData(restApiDataSourceImplementation: RestApiDataSourceImplementation): RestApiDataSource

}