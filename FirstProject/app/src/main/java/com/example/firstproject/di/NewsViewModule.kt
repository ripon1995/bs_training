package com.example.firstproject.di

import androidx.lifecycle.ViewModel
import com.example.firstproject.ui.features.news.presenter.NewsViewModel
import com.example.firstproject.ui.features.news.view.NewsFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class NewsViewModule {

    @ContributesAndroidInjector
    abstract fun bindNewsFragment(): NewsFragment

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    abstract fun bindNewsPresenter(presenter: NewsViewModel): ViewModel
}