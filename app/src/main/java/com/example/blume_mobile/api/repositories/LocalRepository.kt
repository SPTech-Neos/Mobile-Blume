package com.example.blume_mobile.api.repositories

import com.example.blume_mobile.models.local.Local
import com.example.blume_mobile.models.local.LocalRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LocalRepository {
    @POST("locals")
    suspend fun register(@Body request: LocalRequest): Response<Local>
}