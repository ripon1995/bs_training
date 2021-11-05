package com.example.basicmvvmpattern.dataSource.model

data class Story(
    var downloadLinks: List<DownloadLinks>,
    var profilePic: String,
    var fullName: String,
    var status: String,
    var statusCode: Int
)
