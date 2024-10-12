package com.example.blume_mobile.models

data class Product(
    val id: Int? = null,
    val name: String = "",
    val brand: String = "",
    val imgUrl: String? = null,
    val type: ProductType,
    val status: Status,
    val value: Double? = null,
    val establishment: Establishment

) {
}