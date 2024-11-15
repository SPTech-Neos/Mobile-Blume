package com.example.blume_mobile.api.repositories

import com.example.blume_mobile.models.serviceType.ServiceType
import retrofit2.Response
import retrofit2.http.GET

interface ServiceTypeRepository {
    @GET("service-types")
    suspend fun getAll(): Response<List<ServiceType>>
}