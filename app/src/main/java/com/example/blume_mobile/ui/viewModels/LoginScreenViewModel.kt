package com.example.blume_mobile.ui.viewModels

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blume_mobile.api.retrofit.RetrofitService
import com.example.blume_mobile.models.client.Client
import com.example.blume_mobile.models.client.ClientLogin
import com.example.blume_mobile.models.di.UserSession
import com.example.blume_mobile.ui.activties.MainActivity
import com.example.blume_mobile.ui.states.LoginScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import retrofit2.Response

class LoginScreenViewModel() : ViewModel() {
    private val apiClient = RetrofitService.getApiClient()
    private val _uiState: MutableStateFlow<LoginScreenUiState> =
        MutableStateFlow(LoginScreenUiState())

    val uiState get() = _uiState.asStateFlow()


    init {
        _uiState.update { current ->
            current.copy(
                onEmailChange = {
                    _uiState.value = _uiState.value.copy(
                        email = it
                    )
                },

                onPasswordChange = {
                    _uiState.value = _uiState.value.copy(
                        password = it
                    )
                },
            )
        }
    }

    fun login(contexto: Context, userSession: UserSession) {
        val client = ClientLogin(
            _uiState.value.email,
            _uiState.value.password,
        )
        viewModelScope.launch {
            try {
                val getClient = apiClient.login(client)

                if (getClient.isSuccessful) {
                    if (getClient.body() != null) {
                        Log.i("login", "resultado da chamada: ${getClient.body()}")

                        userSession.id = getClient.body()!!.id


                        val nextScreen = Intent(contexto, MainActivity::class.java)

                        contexto.startActivity(nextScreen)

                    }
                } else {
                    Log.e("login", "resultado da chamada: ${getClient.message()}")

                    _uiState.update {
                        _uiState.value.copy(
                            error = "Login e/ou senha inválidos"
                        )
                    }
                }

            } catch (e: Exception) {
                _uiState.update {
                    _uiState.value.copy(
                        error = "Ocorreu um erro, tente novamente mais tarde"
                    )
                }
                Log.e("login", "Erro na chamada: ${e.message} e ${e.cause}")
            }
        }
    }

}
