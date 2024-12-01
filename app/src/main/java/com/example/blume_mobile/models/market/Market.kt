package com.example.blume_mobile.models.market

import com.example.blume_mobile.models.product.Product
import com.example.blume_mobile.models.order.Order

data class Market(
    val id: Int,
    val quantity: Int,
    val product: Product,
    val order: Order
)
