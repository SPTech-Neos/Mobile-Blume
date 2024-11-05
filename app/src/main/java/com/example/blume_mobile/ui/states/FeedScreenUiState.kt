package com.example.blume_mobile.ui.states

import com.example.blume_mobile.models.Establishment
import com.example.blume_mobile.models.Product
import com.example.blume_mobile.models.Service
import com.example.blume_mobile.models.ServiceCategory

data class FeedScreenUiState(
    val establishments: List<Establishment> = emptyList(),
    val services: List<Service> = emptyList(),
    val products: List<Product> = emptyList(),
    val bestEstablishments: List<Establishment> = emptyList(),
    val bestProducts: List<Product> = emptyList(),
    val popularCategories: List<ServiceCategory> = emptyList(),
    val searchedBestEstablishments: List<Establishment> = emptyList(),
    val searchedBestServices: List<Service> = emptyList(),
    val searchedBestProducts: List<Product> = emptyList(),
    val searchedText: String = "",
    val onSearch: (String) -> Unit = {},
    val filtered: String = "Estabelecimentos",
    val onClickFilter: (String) -> Unit = {}
) {
}