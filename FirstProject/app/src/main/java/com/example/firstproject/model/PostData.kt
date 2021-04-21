package com.example.firstproject.model

import com.google.gson.annotations.SerializedName

data class PostData(
    @SerializedName("data")
    var data: List<ProfilePost>
//    val limit: Int,
//    val offset: Int,
//    val page: Int,
//    val total: Int
)