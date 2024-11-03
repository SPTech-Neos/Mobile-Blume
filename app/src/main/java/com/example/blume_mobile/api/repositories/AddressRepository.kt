package com.example.blume_mobile.api.repositories

import com.example.blume_mobile.models.address.Address
import com.example.blume_mobile.models.address.AddressRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AddressRepository {
    @POST("/addresses")
    suspend fun register(@Body request: AddressRequest): Response<Address>
}