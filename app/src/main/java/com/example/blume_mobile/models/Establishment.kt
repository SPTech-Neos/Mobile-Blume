package com.example.blume_mobile.models

data class Establishment(
    val id: Int,
    val aditumId: String,
    val name: String,
    val imgUrl: String?,
    val local: Local,
    val phone: Phone,
    val status: Status,
    val startShit: String,
    val endShift: String,
    val description: String,
    val cnpj: String,
    val media: Double?
) {
}