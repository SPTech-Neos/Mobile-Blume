package com.example.blume_mobile.api.retrofit

import com.example.blume_mobile.api.repositories.EstablishmentRepository
import com.example.blume_mobile.api.repositories.ProductRepository
import com.example.blume_mobile.api.repositories.ServiceRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private val BASE_URL = "http://192.168.15.106:8080/"

    fun getApi(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    fun getApiEstablishments(): EstablishmentRepository {
        return getApi().create(EstablishmentRepository::class.java)
    }

    fun getApiProducts(): ProductRepository {
        return getApi().create(ProductRepository::class.java)
    }

    fun getApiServices(): ServiceRepository {
        return getApi().create(ServiceRepository::class.java)
    }

}