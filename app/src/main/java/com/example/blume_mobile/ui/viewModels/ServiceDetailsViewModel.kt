package com.example.blume_mobile.ui.viewModels

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blume_mobile.api.retrofit.RetrofitService
import com.example.blume_mobile.models.Aditum.PaymentRequest
import com.example.blume_mobile.models.schedule.SchedulingRequest
import com.example.blume_mobile.ui.states.ServiceDetailsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ServiceDetailsViewModel: ViewModel() {
    private val _uiState: MutableStateFlow<ServiceDetailsUiState> = MutableStateFlow(ServiceDetailsUiState(aditumUri = "https://blume-dev.aditum.com.br/v2/checkout/"))
    val uiState = _uiState.asStateFlow()
    val apiEmployeeServices = RetrofitService.getApiEmployeeServices()
    val apiScheduling = RetrofitService.getApiScheduling()
    val apiTokenAditum = RetrofitService.getTokenAditum()
    val apiPaymentAditum = RetrofitService.getPaymentAditum()

    fun generatePaymentLink(requestAditum: PaymentRequest, token: String){

        viewModelScope.launch {
            try {
                val request = apiPaymentAditum.generatePaymentLink(token = token, requestAditum)

                if (request.isSuccessful) {
                    if (request.body() != null) {
                        Log.i("apiAditumPayment", "resultado da chamada: ${request.body()}")
                        _uiState.value = _uiState.value.copy(
                            aditumUri = _uiState.value.aditumUri + request.body()!!.id
                        )
                    }
                } else {
                    Log.e("apiAditumPayment", "resultado da chamada: ${request.errorBody()}")
                    Log.e("apiAditumPayment", "resultado da chamada: ${request.body()}")
                    Log.e("apiAditumPayment", "resultado da chamada: ${request.code()}")

                }

            } catch (e: Exception) {

                Log.e("apiAditumPayment", "Erro na chamada: ${e.message} e ${e.cause}")
            }
        }

    }

    fun getAditumToken(requestAditum: PaymentRequest){

        viewModelScope.launch {
            try {
                val getAditumToken = apiTokenAditum.getTokenAditum("mk_vG0pqXJjikVnUD/MBNaLw")

                if(getAditumToken.isSuccessful){
                    if(getAditumToken.body() != null){
                        Log.i("apiAditum", "resultado da chamada: ${getAditumToken.body()!!.generatedToken}")
                        val token = "Bearer ${getAditumToken.body()!!.generatedToken}"
                        generatePaymentLink(requestAditum, token)
                    }


                }else {
                    Log.e("apiAditum", "resultado da chamada: ${getAditumToken.message()}")
                }

            }catch (e: Exception){
                Log.e("apiAditum", "Erro na chamada: ${e.message} e ${e.cause}")
            }

        }

    }


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