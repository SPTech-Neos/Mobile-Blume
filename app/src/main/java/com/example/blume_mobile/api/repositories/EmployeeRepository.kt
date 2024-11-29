package com.example.blume_mobile.api.repositories

import com.example.blume_mobile.models.employee.Employee
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EmployeeRepository {

    @GET("employees/by-establishment/{id}")
    suspend fun getAllEmployeesByEstablishment(@Path("id") id: Int): Response<List<Employee>>
}