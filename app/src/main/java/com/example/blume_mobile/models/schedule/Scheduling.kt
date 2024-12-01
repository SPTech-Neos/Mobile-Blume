package com.example.blume_mobile.models.schedule

import com.example.blume_mobile.models.client.Client
import com.example.blume_mobile.models.employee.Employee
import com.example.blume_mobile.models.service.Service
import com.example.blume_mobile.models.status.Status
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class Scheduling(
    @SerializedName("idSchedulig") val id: Int,
    val client: Client,
    val service: Service,
    val employee: Employee,
    val status: Status,
    val dateTime: String
) {
}