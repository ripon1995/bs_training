package com.example.firstproject.di

import androidx.lifecycle.ViewModel
import com.example.firstproject.ui.features.profile.presenter.ProfilePostViewModel
import com.example.firstproject.ui.features.profile.view.ProfileDetailsInfoAndPostFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ProfileViewModule {

    @ContributesAndroidInjector
    abstract fun bindProfileDetailsInfoAndPostFragment(): ProfileDetailsInfoAndPostFragment

    @Binds
    @IntoMap
    @ViewModelKey(ProfilePostViewModel::class)
    abstract fun bindProfilePostPresenter(profilePostViewModel: ProfilePostViewModel): ViewModel
}