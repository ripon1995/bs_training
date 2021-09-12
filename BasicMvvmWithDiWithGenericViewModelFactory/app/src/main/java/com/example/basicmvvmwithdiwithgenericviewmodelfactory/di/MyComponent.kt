package com.example.basicmvvmwithdiwithgenericviewmodelfactory.di

import com.example.basicmvvmwithdiwithgenericviewmodelfactory.MyApplication
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.di.hotelOrder.HotelDataActivityModule
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.di.hotelOrder.HotelDataActivityViewModelModule
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.di.hotelOrder.RestApiDataSourceModule
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.di.typeCode.RestApiTypeCodeModule
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.di.typeCode.TypeCodeActivityModule
import com.example.basicmvvmwithdiwithgenericviewmodelfactory.di.typeCode.TypeCodeViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Component(
    modules = [
        AndroidSupportInjectionModule::class,

        ViewModelFactoryModule::class,

        HotelDataActivityViewModelModule::class,
        HotelDataActivityModule::class,
        RestApiDataSourceModule::class,

        TypeCodeViewModelModule::class,
        TypeCodeActivityModule::class,
        RestApiTypeCodeModule::class,
    ]
)

@Singleton
interface MyComponent : AndroidInjector<MyApplication> {
    @Component.Builder
    interface Factory {
        @BindsInstance
        fun create(application: MyApplication): Factory

        fun build(): MyComponent
    }

}