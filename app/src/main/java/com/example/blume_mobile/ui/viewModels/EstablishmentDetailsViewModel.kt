package com.example.blume_mobile.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blume_mobile.api.retrofit.RetrofitService
import com.example.blume_mobile.ui.states.EstablishmentScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EstablishmentDetailsViewModel: ViewModel() {
    private val _uiState: MutableStateFlow<EstablishmentScreenUiState> = MutableStateFlow(EstablishmentScreenUiState())
    val uiState = _uiState.asStateFlow()
    private val apiProduct = RetrofitService.getApiProducts()
    private val apiService = RetrofitService.getApiServices()
    private val apiEmployee = RetrofitService.getApiEmployees()

    init {
        _uiState.update { current ->
            current.copy(
                onClickFilter = {
                    _uiState.value = _uiState.value.copy(
                        filtered = it
                    )
                },
            )
        }
    }

    fun getAllEmployees(id: Int){
        viewModelScope.launch {
            try {
                val getEmployee = apiEmployee.getAllEmployeesByEstablishment(id = id)

                if(getEmployee.isSuccessful){
                    if(getEmployee.body() != null || getEmployee.body()!!.isNotEmpty()){
                        Log.i("apiProduct", "resultado da chamada: ${getEmployee}")
                        _uiState.value = _uiState.value.copy(employees = getEmployee.body()!!)
                        Log.i("apiProduct", "resultado da state: ${_uiState.value}")
                    }
                }else {
                    Log.e("apiProduct", "resultado da chamada: ${getEmployee.message()}")
                }

            }catch (e: Exception){
                Log.e("apiProduct", "Erro na chamada: ${e.message} e ${e.cause}")
            }

        }

    }

     fun getAllProducts(id: Int){
        viewModelScope.launch {
            try {
                val getProduct = apiProduct.getAllProductsByEstablishment(id)

                if(getProduct.isSuccessful){
                    if(getProduct.body() != null || getProduct.body()!!.isNotEmpty()){
                        Log.i("apiProduct", "resultado da chamada: ${getProduct}")
                        _uiState.value = _uiState.value.copy(products = getProduct.body()!!)
                        Log.i("apiProduct", "resultado da state: ${_uiState.value}")
                    }
                }else {
                    Log.e("apiProduct", "resultado da chamada: ${getProduct.message()}")
                }

            }catch (e: Exception){
                Log.e("apiProduct", "Erro na chamada: ${e.message} e ${e.cause}")
            }

        }

    }
    fun getAllServices(id: Int){
        viewModelScope.launch {
            try {
                val getService = apiService.getAllServicesByEstablishment(id = id, status ="ativo")

                if(getService.isSuccessful){
                    if(getService.body() != null || getService.body()!!.isNotEmpty()){
                        _uiState.value = _uiState.value.copy(services = getService.body()!!)
                        Log.i("apiService", "resultado da chamada: ${_uiState.value}")
                    }
                }else {
                    Log.e("apiService", "resultado da chamada: ${getService.message()}")
                }

            }catch (e: Exception){
                Log.e("apiService", "Erro na chamada: ${e.message} e ${e.cause}")
            }

        }

    }


}