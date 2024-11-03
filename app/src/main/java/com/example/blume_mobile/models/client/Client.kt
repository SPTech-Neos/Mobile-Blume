package com.example.blume_mobile.models.client

import com.google.gson.annotations.SerializedName

data class Client(
    @SerializedName("clientId")val id: Int,
    val name: String,
    val email: String,
    val token: String
) {

}