package com.example.hotelorderwithdi.di

import android.app.Application
import com.example.hotelorderwithdi.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [ViewModelFactoryModule::class,
        MainActivityModule::class,
        AndroidSupportInjectionModule::class,
        RestApiDataSourceModule::class,

        MyViewModelModule::class]
)

@Singleton
interface MyComponent : AndroidInjector<MyApplication>{

    @Component.Builder
    interface Factory {
        @BindsInstance
        fun create(application: Application): Factory

        fun build(): MyComponent
    }
}