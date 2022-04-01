package com.example.treeplantationfrontend.datasource.model.responseBody

data class CustomerSignUpResponse(
    val message: String,
    val body: SignUpRequirements
)

data class SignUpRequirements(
    val email: String
)
