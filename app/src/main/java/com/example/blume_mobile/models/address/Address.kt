package com.example.blume_mobile.models.address

data class Address(
    val id: Int,
    val publicPlace: String,
    val city: String,
    val zipCode: String,
    val uf: String
) {
}