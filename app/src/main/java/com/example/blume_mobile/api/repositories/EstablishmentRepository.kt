package com.example.blume_mobile.api.repositories

import com.example.blume_mobile.models.Establishment
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EstablishmentRepository {

    @GET("/establishments/active")
    suspend fun getAllActiveEstablishments(): Response<List<Establishment>>

    @GET("/establishments/best-rating/{count}")
    suspend fun getBestRateds(@Path("count") count: Int): Response<List<Establishment>>

    @GET("/{id}")
    suspend fun getById(@Path("id") id: Int): Response<List<Establishment>>
}