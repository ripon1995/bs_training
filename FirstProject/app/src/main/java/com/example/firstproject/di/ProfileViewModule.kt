package com.example.firstproject.di

import com.example.firstproject.ui.features.profile.presenter.ProfilePostPresenter
import com.example.firstproject.ui.features.profile.presenter.ProfilePostPresenterImplementation
import com.example.firstproject.ui.features.profile.view.ProfileDetailsInfoAndPostFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ProfileViewModule {

    @ContributesAndroidInjector
    abstract fun bindProfileDetailsInfoAndPostFragment(): ProfileDetailsInfoAndPostFragment

    @Binds
    abstract fun bindProfilePostPresenter(profilePostPresenterImplementation: ProfilePostPresenterImplementation): ProfilePostPresenter
}