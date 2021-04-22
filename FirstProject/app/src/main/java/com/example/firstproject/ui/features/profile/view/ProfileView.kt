package com.example.firstproject.ui.features.profile.view

import com.example.firstproject.dataSource.model.ProfileOwner
import com.example.firstproject.dataSource.model.ProfilePost

interface ProfileView {
    fun showProfilePostList(profileList: List<ProfilePost>)
    fun showProfileInfoDetails(profileOwner: ProfileOwner)
}