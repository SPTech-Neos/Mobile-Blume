package com.example.blume_mobile.models.serviceType

import com.example.blume_mobile.models.serviceCategory.ServiceCategory

data class ServiceType(
    val id: Int? = null,
    val name: String = "",
    val serviceCategory: ServiceCategory
)
