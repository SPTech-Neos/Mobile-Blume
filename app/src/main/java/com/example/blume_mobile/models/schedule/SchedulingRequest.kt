package com.example.blume_mobile.models.schedule

data class SchedulingRequest(
    val dateTime: String,
    val idService: Int,
    val idEmployee: Int,
    val idClient: Int
) {
}