package com.example.blume_mobile.ui.states

import com.example.blume_mobile.models.employee.Employee
import com.example.blume_mobile.models.local.Local
import com.example.blume_mobile.models.phone.Phone
import com.example.blume_mobile.models.product.Product
import com.example.blume_mobile.models.service.Service
import java.time.LocalDateTime

data class EstablishmentScreenUiState(
    val filtered: String = "Serviços",
    val onClickFilter: (String) -> Unit = {},
    val services: List<Service> = emptyList(),
    val products: List<Product> = emptyList(),
    val employees: List<Employee> = emptyList(),
)
