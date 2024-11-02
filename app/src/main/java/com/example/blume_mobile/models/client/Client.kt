package com.example.blume_mobile.models.client

import com.example.blume_mobile.models.Local
import com.example.blume_mobile.models.Phone
import com.google.gson.annotations.SerializedName

data class Client(
    @SerializedName("clientId")val id: Int,
    val name: String,
    val email: String,
    val token: String
) {

}