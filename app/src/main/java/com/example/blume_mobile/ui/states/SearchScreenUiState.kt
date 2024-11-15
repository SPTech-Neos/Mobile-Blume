package com.example.blume_mobile.ui.states

import com.example.blume_mobile.models.establishment.Establishment
import com.example.blume_mobile.models.product.Product
import com.example.blume_mobile.models.service.Service
import com.example.blume_mobile.models.serviceType.ServiceType

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