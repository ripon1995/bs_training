package com.example.kotlincoroutineexample.dataRepository.model

import com.google.gson.annotations.SerializedName

data class Movie(

    @SerializedName("name")
    val name: String,

    @SerializedName("imageUrl")
    val imageUrl: String,

    @SerializedName("category")
    val category: String,

    @SerializedName("desc")
    val description: String
)
