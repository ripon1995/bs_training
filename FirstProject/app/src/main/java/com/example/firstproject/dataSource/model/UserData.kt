package com.example.firstproject.dataSource.model

import com.google.gson.annotations.SerializedName

class UserData  {
    @SerializedName("data")
    lateinit var data:List<Post>
}