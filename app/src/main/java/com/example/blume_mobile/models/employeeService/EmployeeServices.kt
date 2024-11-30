package com.example.blume_mobile.models.employeeService

import com.example.blume_mobile.models.employee.Employee
import com.example.blume_mobile.models.service.Service

data class EmployeeServices(
    val id: Int,
    val hoursSpent: Int,
    val expertise: Boolean,
    val employee: Employee,
    val service: Service
)
