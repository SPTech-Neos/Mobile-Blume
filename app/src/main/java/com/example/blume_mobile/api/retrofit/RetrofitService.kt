package com.example.blume_mobile.api.retrofit

import com.example.blume_mobile.api.repositories.EstablishmentRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    val BASE_URL = "http://192.168.245.134/api/"

    fun getApiEstablishments(): EstablishmentRepository{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EstablishmentRepository::class.java)
    }
}