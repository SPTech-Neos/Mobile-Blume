package com.example.blume_mobile.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blume_mobile.api.retrofit.RetrofitService
import com.example.blume_mobile.models.di.UserSession
import com.example.blume_mobile.ui.states.ProfileScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileScreenViewModel(
    id: Int = 0
): ViewModel() {
    private val _uiState: MutableStateFlow<ProfileScreenUiState> = MutableStateFlow(ProfileScreenUiState())
    val uiState = _uiState.asStateFlow()

    private val apiClient = RetrofitService.getApiClient()

    init {
        getClientInfo(id)
    }

    fun getClientInfo(id: Int){
        Log.i("apiClient", "user pra chamada: ${id}")
        viewModelScope.launch {
            try {
                val getClient = apiClient.getById(id)

                if(getClient.isSuccessful){
                    if(getClient.body() != null){
                        _uiState.value = _uiState.value.copy(client = getClient.body()!!)
                        Log.i("apiClient", "resultado da chamada: ${_uiState.value.client}")
                    }
                }else {
                    Log.e("apiClient", "resultado da chamada: ${getClient.body()}")
                }

            }catch (e: Exception){
                Log.e("apiClient", "Erro na chamada: ${e.message} e ${e.cause}")
            }

        }

    }
}