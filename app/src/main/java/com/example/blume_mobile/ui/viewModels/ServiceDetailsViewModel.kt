package com.example.blume_mobile.ui.viewModels

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blume_mobile.api.retrofit.RetrofitService
import com.example.blume_mobile.models.schedule.SchedulingRequest
import com.example.blume_mobile.ui.states.ServiceDetailsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ServiceDetailsViewModel: ViewModel() {
    private val _uiState: MutableStateFlow<ServiceDetailsUiState> = MutableStateFlow(ServiceDetailsUiState())
    val uiState = _uiState.asStateFlow()
    val apiEmployeeServices = RetrofitService.getApiEmployeeServices()
    val apiScheduling = RetrofitService.getApiScheduling()

    fun createScheduling(requestSchedule: SchedulingRequest){
        viewModelScope.launch {
            try {
                val request = apiScheduling.registerScheduling(request = requestSchedule)

                if (request.isSuccessful) {
                    if (request.body() != null) {
                        Log.i("apiScheduling", "resultado da chamada: ${request.body()}")

                    }
                } else {
                    Log.e("apiScheduling", "resultado da chamada: ${request.message()}")

                }

            } catch (e: Exception) {

                Log.e("apiScheduling", "Erro na chamada: ${e.message} e ${e.cause}")
            }
        }

    }

    fun getEmployeesByService(id: Int){
        viewModelScope.launch {
            try {
                val getEmployee = apiEmployeeServices.getAllEmployeesByService(id = id)

                if(getEmployee.isSuccessful){
                    if(getEmployee.body() != null || getEmployee.body()!!.isNotEmpty()){
                        Log.i("apiProduct", "resultado da chamada: ${getEmployee}")
                        _uiState.value = _uiState.value.copy(employeeServices = getEmployee.body()!!)
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
}