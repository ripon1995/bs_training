package com.example.secondproject.di

import com.example.secondproject.repository.RestApiDataSource
import com.example.secondproject.repository.RestApiDataSourceImplementation
import dagger.Binds
import dagger.Module

@Module
abstract class RestApiDataSourceModule {

    @Binds
    abstract fun provideData(restApiDataSourceImplementation: RestApiDataSourceImplementation):RestApiDataSource
}