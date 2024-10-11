package com.example.blume_mobile.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.blume_mobile.api.retrofit.RetrofitService
import com.example.blume_mobile.ui.states.FeedScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FeedScreenViewModel: ViewModel() {

    private val api = RetrofitService.getApiEstablishments()
    private val _uiState: MutableStateFlow<FeedScreenUiState> = MutableStateFlow(FeedScreenUiState())
    val uiState get() = _uiState.asStateFlow()


    init {
        _uiState.update { current ->
            current.copy(
                    onSearch = {
                        _uiState.value = _uiState.value.copy(
                            searchedText = it
                        )
                    }
            )
        }

        viewModelScope.launch {

            try {
                val getEstablishment = api.getAllActiveEstablishments()

                if(getEstablishment.isSuccessful){
                    if(getEstablishment.body() != null || getEstablishment.body()!!.isNotEmpty()){
                        _uiState.value = _uiState.value.copy(establishments = getEstablishment.body()!!)
                        Log.i("api", "resultado da chamada: ${_uiState.value}")
                    }
                }else {
                    Log.e("api", "resultado da chamada: ${getEstablishment.message()}")
                }

            }catch (e: Exception){
                Log.e("api", "Erro na chamada: ${e.message} e ${e.cause}")
            }

        }

    }

}