package com.example.hotelorderwithdi.di

import android.app.Application
import com.example.hotelorderwithdi.MyApplication
import com.example.hotelorderwithdi.di.mainActivity.MainActivityModule
import com.example.hotelorderwithdi.di.mainActivity.MainActivityViewModelFactoryModule
import com.example.hotelorderwithdi.di.mainActivity.MainActivityViewModelModule
import com.example.hotelorderwithdi.di.mainActivity.RestApiDataSourceModule
import com.example.hotelorderwithdi.di.mainActivity2.MainActivity2Module
import com.example.hotelorderwithdi.di.mainActivity2.MainActivity2ViewModelFactoryModuel
import com.example.hotelorderwithdi.di.mainActivity2.MainActivity2ViewModelModule
import com.example.hotelorderwithdi.di.seekBarWithCallBack.SeekBarWithCallBackActivityModule
import com.example.hotelorderwithdi.di.seekBarWithCallBack.SeekBarWithCallBackViewModelModule
import com.example.hotelorderwithdi.di.seekBarWithLiveData.SeekBarWithLiveDataActivityModule
import com.example.hotelorderwithdi.di.seekBarWithLiveData.SeekBarWithLiveDataViewModelModule
import com.example.hotelorderwithdi.di.seekBarWithRxJava.SeekBarWithRxJavaActivityModule
import com.example.hotelorderwithdi.di.seekBarWithRxJava.SeekBarWithRxJavaViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [MainActivityViewModelFactoryModule::class,
        MainActivityModule::class,
        AndroidSupportInjectionModule::class,
        RestApiDataSourceModule::class,
        MainActivityViewModelModule::class,
        SeekBarWithLiveDataActivityModule::class,
        SeekBarWithLiveDataViewModelModule::class,
        SeekBarWithRxJavaActivityModule::class,
        SeekBarWithRxJavaViewModelModule::class,
        SeekBarWithCallBackActivityModule::class,
        SeekBarWithCallBackViewModelModule::class,
        MainActivity2Module::class,
        MainActivity2ViewModelFactoryModuel::class,
        MainActivity2ViewModelModule::class]
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