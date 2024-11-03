package com.example.blume_mobile.ui.states

import android.net.Uri
import com.example.blume_mobile.models.address.Address
import com.example.blume_mobile.models.client.Client
import com.example.blume_mobile.models.local.Local
import com.example.blume_mobile.models.phone.Phone

data class RegisterScreenUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val cpf: String = "",
    val phone: String = "",
    val postalCode: String = "",
    val publicPlace: String = "",
    val number: String = "",
    val complement: String = "",
    val countryState: String = "",
    val url: Uri? = null,
    val onUrlChange: (Uri) -> Unit = {},
    val onNameChange: (String) -> Unit = {},
    val onEmailChange: (String) -> Unit = {},
    val onPasswordChange: (String) -> Unit = {},
    val onConfirmPasswordChange: (String) -> Unit = {},
    val onCpfChange: (String) -> Unit = {},
    val onPhoneChange: (String) -> Unit = {},
    val onPostalCodeChange: (String) -> Unit = {},
    val onPublicPlaceChange: (String) -> Unit = {},
    val onNumberChange: (String) -> Unit = {},
    val onComplementChange: (String) -> Unit = {},
    val onCountryStateChange: (String) -> Unit = {},
    val addressResponse: Address? = null,
    val localResponse: Local? = null,
    val clientResponse: Client? = null,
    val phoneResponse: Phone? = null,
    val stepper: Int = 1,
    val moveStepper: (String) -> Unit = {}
) {
}