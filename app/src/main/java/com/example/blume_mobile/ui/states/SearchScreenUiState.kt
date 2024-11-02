package com.example.blume_mobile.ui.states

import com.example.blume_mobile.models.Establishment
import com.example.blume_mobile.models.Service
import com.example.blume_mobile.models.ServiceCategory

data class SearchScreenUiState(
    val searchEstablishments: List<Establishment> = emptyList(),
    val searchServices: List<Service> = emptyList(),
    val searchedText: String = "",
    val serviceCategories: List<ServiceCategory> = emptyList(),
    val onSearch: (String) -> Unit = {},
    val filtered: String = "Estabelecimentos",
    val onClickFilter: (String) -> Unit = {}
) {
}