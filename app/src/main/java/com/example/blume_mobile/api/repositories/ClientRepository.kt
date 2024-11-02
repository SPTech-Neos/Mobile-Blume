package com.example.blume_mobile.api.repositories

import com.example.blume_mobile.models.client.Client
import com.example.blume_mobile.models.client.ClientLogin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ClientRepository {

    @POST("/clients/login")
    suspend fun login(@Body request: ClientLogin): Response<Client>
}