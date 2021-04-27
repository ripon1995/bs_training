package com.example.firstproject.ui.features.profile.presenter

import com.example.firstproject.ui.features.profile.view.ProfileView
import java.lang.ref.WeakReference

abstract class ProfilePostPresenter {

    var view: WeakReference<ProfileView> = WeakReference(null)

    abstract fun fetchProfilePost(id: String)

    abstract fun fetchProfileInfo(id: String)

    fun bindView(view: ProfileView) {
        this.view = WeakReference(view)
    }

    fun detachView() {
        view.clear()
    }
}