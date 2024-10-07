package com.example.blume_mobile.ui.viewModels

import androidx.lifecycle.ViewModel
import com.example.blume_mobile.ui.states.RegisterScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterScreenViewModel: ViewModel() {

    private val _uiState: MutableStateFlow<RegisterScreenUiState> = MutableStateFlow(RegisterScreenUiState())

    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update { current ->
            current.copy (
                onNameChange = {
                    _uiState.value = _uiState.value.copy(
                        name = it
                    )
                },
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
                onConfirmPasswordChange = {
                    _uiState.value = _uiState.value.copy(
                        confirmPassword = it
                    )
                },
                onCpfChange = {
                    _uiState.value = _uiState.value.copy(
                        cpf = it
                    )
                },
                onPhoneChange = {
                    _uiState.value = _uiState.value.copy(
                        phone = it
                    )
                },
                onPostalCodeChange = {
                    _uiState.value = _uiState.value.copy(
                        postalCode = it
                    )
                },
                onPublicPlaceChange = {
                    _uiState.value = _uiState.value.copy(
                        publicPlace = it
                    )
                },
                onNumberChange = {
                    _uiState.value = _uiState.value.copy(
                        number = it
                    )
                },

                onComplementChange = {
                    _uiState.value = _uiState.value.copy(
                        complement = it
                    )
                },
                onStateChange = {
                    _uiState.value = _uiState.value.copy(
                        state = it
                    )
                }
            )
        }
    }
}