package com.example.firstproject.model

import com.google.gson.annotations.SerializedName

data class Profile(

    @SerializedName("owner")
    val user: User,
    @SerializedName("publishDate")
    val publishDate: String,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("likes")
    val likes: Int
)