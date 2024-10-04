package com.example.blume_mobile.models

import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("statusId") val id: Int,
    val name: String,
    val type: String
)
