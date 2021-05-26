package com.example.secondproject.di

import android.app.Application
import com.example.secondproject.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Component(
    modules = [AndroidSupportInjectionModule::class,
        AcitivityModule::class,
        RestApiDataSourceModule::class,
        MainViewModule::class,
        AppModule::class]
)
@Singleton
interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Builder
    interface Factory {
        @BindsInstance
        fun create(application: Application): Factory

        fun build(): AppComponent
    }
}