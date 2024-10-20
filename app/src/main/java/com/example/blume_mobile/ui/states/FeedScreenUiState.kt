package com.example.blume_mobile.ui.states

import com.example.blume_mobile.models.Establishment
import com.example.blume_mobile.models.Product
import com.example.blume_mobile.models.Service
import com.example.blume_mobile.models.ServiceCategory

data class FeedScreenUiState(
    val establishments: List<Establishment> = emptyList(),
    val bestEstablishments: List<Establishment> = emptyList(),
    val bestServices: List<Service> = emptyList(),
    val bestProducts: List<Product> = emptyList(),
    val popularCategories: List<ServiceCategory> = emptyList(),
    val searchedBestEstablishments: List<Establishment> = emptyList(),
    val searchedBestService: Service? = null,
    val searchedText: String = "",
    val filtered: String = "Estabelecimentos",
    val onSearch: (String) -> Unit = {},
    val onClickFilter: (String) -> Unit = {}
) {
}