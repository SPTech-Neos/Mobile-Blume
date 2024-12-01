package com.example.blume_mobile.api.repositories

import com.example.blume_mobile.models.order.OrderRequest
import com.example.blume_mobile.models.order.Order
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface OrderRepository {

    @POST("orders")
    suspend fun registerOrder(@Body request: OrderRequest): Response<Order>
}