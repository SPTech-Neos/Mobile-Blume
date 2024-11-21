package com.example.blume_mobile.models.client

import com.example.blume_mobile.models.local.Local
import com.example.blume_mobile.models.phone.Phone
import com.google.gson.annotations.SerializedName

data class ClientResponse(
    @SerializedName("idClient")val id: Int,
    val name: String,
    val email: String,
    val local: Local,
    val phone: Phone
)
