package com.example.blume_mobile.api.repositories

import com.example.blume_mobile.models.Aditum.PaymentRequest
import com.example.blume_mobile.models.Aditum.PaymentResponse
import com.example.blume_mobile.models.Aditum.TokenAditum
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface AditumRepository {
    @GET("v1/Login/GenerateToken")
    suspend fun getTokenAditum(@Query("MerchantToken") merchantToken: String): Response<TokenAditum>

    @POST("v2/paymentlink")
    suspend fun generatePaymentLink(@Header("Authorization") token: String, @Body paymentRequest: PaymentRequest): Response<PaymentResponse>
}