package com.example.blume_mobile.ui.states

import android.content.Context
import com.example.blume_mobile.models.client.ClientLogin

data class LoginScreenUiState(
    val email: String = "",
    val password: String = "",
    val onEmailChange: (String) -> Unit = {},
    val onPasswordChange: (String) -> Unit = {},
    val loginSucessful: Boolean = false,
    val error: String = ""
) {
}