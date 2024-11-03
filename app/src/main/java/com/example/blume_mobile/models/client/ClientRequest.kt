package com.example.blume_mobile.models.client

data class ClientRequest(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val imgUrl: String = "",
    val local: Int,
    val phone: Int
)
