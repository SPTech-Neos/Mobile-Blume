package com.example.blume_mobile.api.repositories

import com.example.blume_mobile.models.product.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductRepository {

    @GET("products")
    suspend fun getAllProducts(): Response<List<Product>>

    @GET("products/establishment/{id}")
    suspend fun getAllProductsByEstablishment(@Path("id") id: Int): Response<List<Product>>
}