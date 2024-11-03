package com.example.blume_mobile.api.repositories

import com.example.blume_mobile.models.phone.Phone
import com.example.blume_mobile.models.phone.PhoneRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PhoneRepository {

    @POST("/phones")
    suspend fun register(@Body request: PhoneRequest): Response<Phone>
}