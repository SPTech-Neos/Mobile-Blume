package com.example.blume_mobile.models.order

import com.example.blume_mobile.models.status.Status
import com.example.blume_mobile.models.client.Client
import java.time.LocalDateTime

data class Order(
    val id: Int,
    val dateTime: String,
    val status: Status,
    val client: Client
)
