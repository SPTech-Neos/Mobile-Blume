package com.example.blume_mobile.models.employee

import com.example.blume_mobile.models.employeeType.EmployeeType
import com.example.blume_mobile.models.establishment.Establishment
import com.example.blume_mobile.models.local.Local
import com.example.blume_mobile.models.phone.Phone
import com.example.blume_mobile.models.status.Status

data class Employee(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    val imgUrl: String,
    val establishment: Establishment,
    val local: Local,
    val phone: Phone,
    val status: Status,
    val employeeType: EmployeeType
)
