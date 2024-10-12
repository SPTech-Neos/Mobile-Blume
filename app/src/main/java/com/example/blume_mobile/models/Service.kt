package com.example.blume_mobile.models

import android.net.Uri
import java.math.BigDecimal

data class Service(
    val id: Int? = null,
    val specification: String = "",
    val aditumId: String = "",
    val price: Double? = null,
    val imgUrl: String? = null,
    val serviceType: ServiceType,
    val status: Status,
)