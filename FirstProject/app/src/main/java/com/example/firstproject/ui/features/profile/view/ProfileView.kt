package com.example.firstproject.ui.features.profile.view

import com.example.firstproject.dataSource.model.ProfilePost

interface ProfileView {
    fun showProfileList(profileList: List<ProfilePost>)
}