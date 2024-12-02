package com.example.blume_mobile.ui.states

import com.example.blume_mobile.models.employeeService.EmployeeServices

data class ServiceDetailsUiState(
    val employeeServices: List<EmployeeServices> = emptyList(),
    val aditumUri: String,

    ) {
}