package com.example.blume_mobile.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blume_mobile.api.retrofit.RetrofitService
import com.example.blume_mobile.ui.states.OrderScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class OrderScreenViewModel: ViewModel() {
    private val _uiState: MutableStateFlow<OrderScreenUiState> = MutableStateFlow(OrderScreenUiState())
    val apiMarket = RetrofitService.getApiMarket()
    val apiSchedule = RetrofitService.getApiScheduling()

    val uiState = _uiState.asStateFlow()

    init {
        _uiState.update { current ->
            current.copy(
                onClickFilter = {
                    _uiState.value = _uiState.value.copy(
                        filtered = it
                    )
                }
            )
        }
    }

    fun getAllMarkets(id: Int){
        viewModelScope.launch {
            try {
                val getMarket = apiMarket.getMarketByClient(id)

                if(getMarket.isSuccessful){
                    if(getMarket.body() != null || getMarket.body()!!.isNotEmpty()){
                        _uiState.value = _uiState.value.copy(markets = getMarket.body()!!)
                        Log.i("apiMarket", "resultado da chamada: ${_uiState.value}")
                    }
                }else {
                    Log.e("apiMarket", "resultado da chamada: ${getMarket.errorBody()}")
                }

            }catch (e: Exception){
                Log.e("apiService", "Erro na chamada: ${e.message} e ${e.cause}")
            }

        }

    }

    fun getAllSchedulings(id: Int){
        viewModelScope.launch {
            try {
                val getSchedule = apiSchedule.getSchedulingsByClient(id)

                if(getSchedule.isSuccessful){
                    if(getSchedule.body() != null || getSchedule.body()!!.isNotEmpty()){
                        _uiState.value = _uiState.value.copy(schedules = getSchedule.body()!!)
                        Log.i("apiMarket", "resultado da chamada: ${_uiState.value}")
                    }
                }else {
                    Log.e("apiMarket", "resultado da chamada: ${getSchedule.errorBody()}")
                }

            }catch (e: Exception){
                Log.e("apiService", "Erro na chamada: ${e.message} e ${e.cause}")
            }

        }

    }

}
