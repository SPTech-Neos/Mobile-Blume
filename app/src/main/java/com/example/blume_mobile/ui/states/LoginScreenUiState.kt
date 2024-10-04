package com.example.blume_mobile.ui.states

data class LoginScreenUiState(
    val email: String = "",
    val password: String = "",
    val onEmailChange: (String) -> Unit = {},
    val onPasswordChange: (String) -> Unit = {},
) {
}