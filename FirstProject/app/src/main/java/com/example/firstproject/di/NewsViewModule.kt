package com.example.firstproject.di

import com.example.firstproject.ui.features.news.presenter.NewsPresenter
import com.example.firstproject.ui.features.news.presenter.NewsPresenterImplentation
import com.example.firstproject.ui.features.news.view.NewsFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NewsViewModule {

    @ContributesAndroidInjector
    abstract fun bindNewsFragment(): NewsFragment

    @Binds
    abstract fun bindNewsPresenter(presenter: NewsPresenterImplentation): NewsPresenter
}