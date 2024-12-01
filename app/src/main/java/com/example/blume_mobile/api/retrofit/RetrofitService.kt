package com.example.blume_mobile.api.retrofit

import com.example.blume_mobile.api.repositories.AddressRepository
import com.example.blume_mobile.api.repositories.ClientRepository
import com.example.blume_mobile.api.repositories.EmployeeRepository
import com.example.blume_mobile.api.repositories.EmployeeServices
import com.example.blume_mobile.api.repositories.EstablishmentRepository
import com.example.blume_mobile.api.repositories.LocalRepository
import com.example.blume_mobile.api.repositories.MarketRepository
import com.example.blume_mobile.api.repositories.OrderRepository
import com.example.blume_mobile.api.repositories.PhoneRepository
import com.example.blume_mobile.api.repositories.ProductRepository
import com.example.blume_mobile.api.repositories.SchedulingRepository
import com.example.blume_mobile.api.repositories.ServiceRepository
import com.example.blume_mobile.api.repositories.ServiceTypeRepository
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

    fun getApiClient(): ClientRepository {
        return getApi().create(ClientRepository::class.java)
    }

    fun getApiLocal(): LocalRepository {
        return getApi().create(LocalRepository::class.java)
    }

    fun getApiAddress(): AddressRepository {
        return getApi().create(AddressRepository::class.java)
    }

    fun getApiPhone(): PhoneRepository {
        return getApi().create(PhoneRepository::class.java)
    }

    fun getApiServiceType(): ServiceTypeRepository {
        return getApi().create(ServiceTypeRepository::class.java)
    }

    fun getApiEmployees(): EmployeeRepository {
        return getApi().create(EmployeeRepository::class.java)
    }

    fun getApiEmployeeServices(): EmployeeServices {
        return getApi().create(EmployeeServices::class.java)
    }

    fun getApiScheduling(): SchedulingRepository {
        return getApi().create(SchedulingRepository::class.java)
    }

    fun getApiOrder(): OrderRepository {
        return getApi().create(OrderRepository::class.java)
    }

    fun getApiMarket(): MarketRepository {
        return getApi().create(MarketRepository::class.java)
    }

}