package com.example.blume_mobile.ui.states

import com.example.blume_mobile.models.Establishment
import com.example.blume_mobile.models.Service

data class SearchScreenUiState(
    val searchEstablishments: List<Establishment> = emptyList(),
    val searchServices: List<Service> = emptyList(),
    val searchedText: String = "",
    val onSearch: (String) -> Unit = {}
) {
}