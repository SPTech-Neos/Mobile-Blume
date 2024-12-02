package com.example.blume_mobile.api.repositories

import com.example.blume_mobile.models.schedule.Scheduling
import com.example.blume_mobile.models.schedule.SchedulingRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SchedulingRepository {
    @POST("schedulings")
    suspend fun registerScheduling(@Body request: SchedulingRequest): Response<Scheduling>

    @GET("schedulings/client/{id}")
    suspend fun getSchedulingsByClient(@Path("id") id: Int): Response<List<Scheduling>>
}