package com.example.blume_mobile.ui.states

import com.example.blume_mobile.models.market.Market
import com.example.blume_mobile.models.order.Order
import com.example.blume_mobile.models.schedule.Scheduling

data class OrderScreenUiState(
    val markets: List<Market> = emptyList(),
    val schedules: List<Scheduling> = emptyList(),
    val filtered: String = "Todos",
    val onClickFilter: (String) -> Unit = {}

) {
}