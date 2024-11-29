package com.example.blume_mobile.api.repositories

import com.example.blume_mobile.models.service.Service
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceRepository {

    @GET("services")
    suspend fun getAllServices(): Response<List<Service>>

    @GET("services/by-establishment/{id}")
    suspend fun getAllServicesByEstablishment(@Path("id") id: Int, @Query("status") status: String): Response<List<Service>>

}