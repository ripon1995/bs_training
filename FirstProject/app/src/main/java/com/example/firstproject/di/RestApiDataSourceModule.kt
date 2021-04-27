package com.example.firstproject.di

import com.example.firstproject.dataSource.RestApiDataSource
import com.example.firstproject.dataSource.RestApiDataSourceImplementation
import dagger.Binds
import dagger.Module

@Module
abstract class RestApiDataSourceModule {

    @Binds
    abstract fun provideData(restApiDataSourceImplementation: RestApiDataSourceImplementation): RestApiDataSource
}