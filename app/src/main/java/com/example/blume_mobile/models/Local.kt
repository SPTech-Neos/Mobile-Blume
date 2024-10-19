package com.example.blume_mobile.models

data class Local(
    val id: Int,
    val number: Int,
    val floor: String?,
    val complement: String?,
    val block: String?,
    val address: Address
) {
}