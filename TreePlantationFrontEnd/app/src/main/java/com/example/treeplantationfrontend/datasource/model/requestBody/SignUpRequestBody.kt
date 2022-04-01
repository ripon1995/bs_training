package com.example.treeplantationfrontend.datasource.model.requestBody

data class SignUpRequestBody(
    val username: String,
    val name: String,
    val email: String,
    val password: String,
    val phone: String
)
