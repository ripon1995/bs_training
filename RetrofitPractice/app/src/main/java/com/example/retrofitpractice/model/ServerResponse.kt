package com.example.retrofitpractice.model

data class ServerResponse(
    val asn: String,
    val asn_org: String,
    val city: String,
    val country: String,
    val country_eu: Boolean,
    val country_iso: String,
    val hostname: String,
    val ip: String,
    val ip_decimal: Int,
    val latitude: Double,
    val longitude: Double,
    val region_code: String,
    val region_name: String,
    val time_zone: String,
    val user_agent: UserAgent,
    val zip_code: String
)