package com.example.blume_mobile.api.repositories

import com.example.blume_mobile.models.client.Client
import com.example.blume_mobile.models.client.ClientLogin
import com.example.blume_mobile.models.client.ClientRequest
import com.example.blume_mobile.models.client.ClientResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ClientRepository {

    @POST("clients/login")
    suspend fun login(@Body request: ClientLogin): Response<Client>

    @POST("clients")
    suspend fun register(@Body request: ClientRequest): Response<Client>

    @GET("clients/{id}")
    suspend fun getById(@Path("id") id: Int): Response<ClientResponse>
}