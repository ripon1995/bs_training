package com.example.firstproject.di

import android.app.Application
import com.example.firstproject.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [AndroidSupportInjectionModule::class,
        ActivityModule::class,
        RestApiDataSourceModule::class,
        NewsViewModule::class,
        ProfileViewModule::class,
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