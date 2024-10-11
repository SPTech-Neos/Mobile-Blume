package com.example.blume_mobile.api.retrofit

import com.example.blume_mobile.api.repositories.EstablishmentRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private val BASE_URL = "http://192.168.188.67:8080/"

    fun getApiEstablishments(): EstablishmentRepository{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EstablishmentRepository::class.java)
    }
}