package com.example.blume_mobile.models.order

data class OrderRequest(
    val fkStatus: Int,
    val fkClient: Int,
    val dateTime: String,
)
