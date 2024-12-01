package com.example.blume_mobile.ui.states

import com.example.blume_mobile.models.order.Order

data class OrderScreenUiState(
    val orders: List<Order> = emptyList(),
    val filtered: String = "Todos",
    val onClickFilter: (String) -> Unit = {}

) {
}