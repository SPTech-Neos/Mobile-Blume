package com.example.blume_mobile.api.repositories

import com.example.blume_mobile.models.market.Market
import com.example.blume_mobile.models.market.MarketRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MarketRepository {
    @POST("markets")
    suspend fun registerMarket(@Body request: MarketRequest): Response<Market>

    @GET("markets/clientId/{id}")
    suspend fun getMarketByClient(@Path("id") id: Int): Response<List<Market>>
}