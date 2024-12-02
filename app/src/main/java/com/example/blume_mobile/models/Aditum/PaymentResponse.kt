package com.example.blume_mobile.models.Aditum

data class PaymentResponse(
    val id: String,
    val smartCheckoutUrl: String,
    val products: List<AditumProduct>,
    val success: Boolean,
)
