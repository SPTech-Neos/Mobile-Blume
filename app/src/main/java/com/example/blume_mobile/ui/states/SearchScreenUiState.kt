package com.example.blume_mobile.ui.states

import com.example.blume_mobile.models.Establishment
import com.example.blume_mobile.models.Product
import com.example.blume_mobile.models.Service
import com.example.blume_mobile.models.ServiceCategory
import com.example.blume_mobile.models.ServiceType

data class SearchScreenUiState(
    val searchEstablishments: List<Establishment> = emptyList(),
    val searchServices: List<Service> = emptyList(),
    val searchProducts: List<Product> = emptyList(),
    val searchedText: String = "",
    val serviceTypes: List<ServiceType> = emptyList(),
    val onSearch: (String) -> Unit = {},
    val filtered: String = "Estabelecimentos",
    val onClickFilter: (String) -> Unit = {}
) {
}