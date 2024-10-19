package com.example.blume_mobile.api.repositories

import com.example.blume_mobile.models.Product
import com.example.blume_mobile.models.Service
import retrofit2.Response
import retrofit2.http.GET

interface ServiceRepository {

    @GET("/services")
    suspend fun getAllServices(): Response<List<Service>>
}