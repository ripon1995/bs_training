package com.example.hotelorderwithhilt.di

import android.app.Application
import com.example.hotelorderwithhilt.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidSupportInjectionModule::class,

        ViewModelFactoryModule::class,

        MainActivityModule::class,
        RestApiDataSourceModule::class,
        MainActivityViewModelModule::class
    ]
)

@Singleton
interface MyComponent : AndroidInjector<MyApplication> {

    @Component.Builder
    interface Factory {
        @BindsInstance
        fun create(application: Application): Factory

        fun build(): MyComponent
    }
}