package com.example.blume_mobile.data

import com.example.blume_mobile.models.Service
import com.example.blume_mobile.models.ServiceCategory
import com.example.blume_mobile.models.ServiceType
import com.example.blume_mobile.models.Status

val serviceCategory = ServiceCategory(
    id = 1,
    name = "Categoria01"
)

val serviceType = ServiceType(
    id = 1,
    name = "Tipo01",
    serviceCategory = serviceCategory
)

val sampleServices = listOf(
    Service(
        id = 1,
        serviceType = serviceType,
        price = 90.0,
        imgUrl = "",
        status = status,
        aditumId = "",
        specification = "Corte de cabelo"
    ),
    Service(
        id = 2,
        serviceType = serviceType,
        price = 90.0,
        imgUrl = "'",
        status = status,
        aditumId = "",
        specification = "Moicano"
    )
)