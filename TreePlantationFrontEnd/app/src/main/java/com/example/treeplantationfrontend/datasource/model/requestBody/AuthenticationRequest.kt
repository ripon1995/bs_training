package com.example.treeplantationfrontend.datasource.model.requestBody

data class AuthenticationRequest(
    val email: String,
    val username: String,
    val password: String
)
