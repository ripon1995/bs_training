package com.example.firstproject.model

data class Data(
    val owner: Owner,
    val publishDate: String,
    val tags: List<String>,
    val likes: Int
)