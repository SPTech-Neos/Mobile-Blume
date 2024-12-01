package com.example.blume_mobile.ui.states

import com.example.blume_mobile.models.client.ClientResponse
import com.example.blume_mobile.models.order.Order

data class ProfileScreenUiState(
    val client: ClientResponse? = null,
    val lastOrders: List<Order> = emptyList()
) {

}