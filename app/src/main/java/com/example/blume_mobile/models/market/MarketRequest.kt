package com.example.blume_mobile.models.market

data class MarketRequest(
    val quantity: Int,
    val fkProduct: Int,
    val fkOrder: Int
) {
}