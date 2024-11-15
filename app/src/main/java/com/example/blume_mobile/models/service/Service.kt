package com.example.blume_mobile.models.service

import com.example.blume_mobile.models.serviceType.ServiceType
import com.example.blume_mobile.models.status.Status

data class Service(
    val id: Int? = null,
    val specification: String = "",
    val aditumId: String = "",
    val price: Double? = null,
    val imgUrl: String? = null,
    val serviceType: ServiceType,
    val status: Status,
)