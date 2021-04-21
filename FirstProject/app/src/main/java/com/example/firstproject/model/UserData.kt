package com.example.firstproject.model

import com.google.gson.annotations.SerializedName

class UserData  {
    @SerializedName("data")
    lateinit var data:List<Post>
}