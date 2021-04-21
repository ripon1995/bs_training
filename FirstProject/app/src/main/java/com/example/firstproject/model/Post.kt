package com.example.firstproject.model

import com.google.gson.annotations.SerializedName

data class Post(

    @SerializedName("owner")
    val user: User,
    @SerializedName("publishDate")
    val publishDate: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("image")
    val image:String,
    @SerializedName("likes")
    val likes: Int
)