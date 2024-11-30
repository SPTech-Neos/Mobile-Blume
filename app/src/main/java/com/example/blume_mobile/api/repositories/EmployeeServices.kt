package com.example.blume_mobile.api.repositories

import com.example.blume_mobile.models.employeeService.EmployeeServices
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EmployeeServices {
    @GET("employee-services/by-service/{id}")
    suspend fun getAllEmployeesByService(@Path("id") id: Int): Response<List<EmployeeServices>>
}