package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di

import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.MyApplication
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di.hotelOrder.HotelDataActivityModule
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di.hotelOrder.HotelDataActivityViewModelFactoryModule
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di.hotelOrder.HotelDataActivityViewModelModule
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di.typeCode.TypeCodeActivityModule
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di.typeCode.TypeCodeViewModelFactoryModule
import com.example.basicmvvmwithdiwithnongenericviewmodelfactory.di.typeCode.TypeCodeViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        RestApiDataSourceModule::class,
        RestApiTypeCodeModule::class,

        HotelDataActivityViewModelModule::class,
        HotelDataActivityViewModelFactoryModule::class,
        HotelDataActivityModule::class,

        TypeCodeViewModelModule::class,
        TypeCodeViewModelFactoryModule::class,
        TypeCodeActivityModule::class
    ]
)

@Singleton
interface MyComponent : AndroidInjector<MyApplication> {
    @Component.Builder
    interface Factory{
        @BindsInstance
        fun create(application: MyApplication):Factory

        fun build():MyComponent
    }

}