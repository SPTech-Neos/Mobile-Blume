package com.example.blume_mobile.models.Aditum

data class PaymentRequest(
    val emailNotification: String,
    val phoneNotification: String,
    val products: List<String>,
    val maxInstallmentNumber: Int,
    val supportMultipleTransactions: Boolean
)
