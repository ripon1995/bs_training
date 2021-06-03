package com.example.hotelorderwithhilt.di

import com.example.hotelorderwithhilt.dataSource.remoteDataSource.RestApiDataSource
import com.example.hotelorderwithhilt.dataSource.remoteDataSource.RestApiDataSourceImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.DisableInstallInCheck

@InstallIn(SingletonComponent::class)
@Module
abstract class RestApiDataSourceModule {

    @Binds
    abstract fun provideData(restApiDataSourceImplementation: RestApiDataSourceImplementation): RestApiDataSource

}