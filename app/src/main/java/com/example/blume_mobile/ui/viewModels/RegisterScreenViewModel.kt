package com.example.blume_mobile.ui.viewModels

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blume_mobile.api.retrofit.RetrofitService
import com.example.blume_mobile.models.phone.Phone
import com.example.blume_mobile.models.address.Address
import com.example.blume_mobile.models.address.AddressRequest
import com.example.blume_mobile.models.client.ClientRequest
import com.example.blume_mobile.models.local.Local
import com.example.blume_mobile.models.local.LocalRequest
import com.example.blume_mobile.models.phone.PhoneRequest
import com.example.blume_mobile.ui.activties.LoginActivity
import com.example.blume_mobile.ui.states.RegisterScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.internal.wait

class RegisterScreenViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<RegisterScreenUiState> =
        MutableStateFlow(RegisterScreenUiState())

    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update { current ->
            current.copy(
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
                onCountryStateChange = {
                    _uiState.value = _uiState.value.copy(
                        countryState = it
                    )
                },
                onUrlChange = {
                    _uiState.value = _uiState.value.copy(
                        url = it
                    )
                },
                moveStepper = {
                    if(it == "next"){
                        _uiState.value = _uiState.value.copy(
                            stepper = _uiState.value.stepper + 1
                        )
                    }else{
                        _uiState.value = _uiState.value.copy(
                            stepper = _uiState.value.stepper - 1
                        )
                    }
                }
            )
        }
    }

    fun registerClient(contexto: Context){
        registerAddress(contexto)
    }

    fun registerAddress(contexto: Context) {
        val a = AddressRequest(
            _uiState.value.publicPlace,
            _uiState.value.complement,
            _uiState.value.postalCode,
            _uiState.value.countryState,
        )

        val getAddressApi = RetrofitService.getApiAddress()

        viewModelScope.launch {
            try {
                val request = getAddressApi.register(a)

                if (request.isSuccessful) {
                    if (request.body() != null) {
                        Log.i("apiAddress", "resultado da chamada: ${request.body()}")
                        _uiState.update {
                            _uiState.value.copy(
                                addressResponse = request.body()
                            )
                        }

                        registerLocal(_uiState.value.addressResponse!!.id, contexto)

                        Log.i(
                            "apiAddress",
                            "resultado da uiState: ${_uiState.value.addressResponse}"
                        )
                    }
                } else {
                    Log.e("apiAddress", "resultado da chamada: ${request.message()}")

                }

            } catch (e: Exception) {

                Log.e("apiAddress", "Erro na chamada: ${e.message} e ${e.cause}")
            }
        }
    }

    fun registerLocal(idAddress: Int, contexto: Context): Local {
        val getLocalApi = RetrofitService.getApiLocal()


        try {
            viewModelScope.launch {

                val l = LocalRequest(
                    complement = _uiState.value.complement,
                    block = null,
                    floor = null,
                    number = _uiState.value.number.toInt(),
                    address = idAddress
                )

                val request = getLocalApi.register(l)

                if (request.isSuccessful) {
                    if (request.body() != null) {
                        Log.i("apiLocal", "resultado da chamada: ${request.body()}")

                        _uiState.update {
                            _uiState.value.copy(
                                localResponse = request.body()
                            )
                        }

                        registerPhone(contexto, _uiState.value.localResponse!!.id)

                        Log.i("apiLocal", "resultado da uiState: ${_uiState.value.localResponse}")
                    }
                } else {
                    Log.e("apiLocal", "resultado da chamada: ${request.message()}")

                }
            }

        } catch (e: Exception) {

            Log.e("apiLocal", "Erro na chamada: ${e.message} e ${e.cause}")
        }

        return _uiState.value.localResponse!!
    }

    fun registerPhone(contexto: Context, idLocal: Int) {

        Log.i("number: ", _uiState.value.phone)
        val areaCorde = _uiState.value.phone.substring(0, 2)
        val phone = _uiState.value.phone.substring(2)
        Log.i("number:", phone)

        val p = PhoneRequest(
            number = phone,
            countryCode = "55",
            areaCode = areaCorde
        )

        val getPhoneApi = RetrofitService.getApiPhone()

        try {
            viewModelScope.launch {
                val request = getPhoneApi.register(p)

                if (request.isSuccessful) {
                    if (request.body() != null) {
                        Log.i("login", "resultado da chamada: ${request.body()}")
                        _uiState.update {
                            _uiState.value.copy(
                                phoneResponse = request.body()
                            )
                        }

                        register(contexto, _uiState.value.phoneResponse!!.id, idLocal)
                        Log.i("apiAddress", "resultado da uiState: ${_uiState.value.phoneResponse}")
                    }
                } else {
                    Log.e("login", "resultado da chamada: ${request.message()}")

                }
            }

        } catch (e: Exception) {

            Log.e("login", "Erro na chamada: ${e.message} e ${e.cause}")
        }

    }

    fun register(context: Context, idPhone: Int, idLocal: Int) {
        val apiClient = RetrofitService.getApiClient()

        viewModelScope.launch {

            val client = ClientRequest(
                name = _uiState.value.name,
                imgUrl = _uiState.value.url.toString(),
                password = _uiState.value.password,
                email = _uiState.value.email,
                local = idLocal,
                phone = idPhone
            )
            Log.i("apiClient", "request: ${client}")

            try {
                val request = apiClient.register(client)

                if (request.isSuccessful) {
                    if (request.body() != null) {
                        Log.i("apiClient", "resultado da chamada: ${request.body()}")

                        _uiState.update {
                            _uiState.value.copy(
                                clientResponse = request.body()
                            )
                        }

                        Log.i("apiClient", "resultado da uiState: ${_uiState.value.addressResponse}")

                        val nextScreen = Intent(context, LoginActivity::class.java)

                        context.startActivity(nextScreen)

                    }
                } else {
                    Log.e("apiClient", "resultado da chamada: ${request.body()}")

                }

            } catch (e: Exception) {

                Log.e("apiClient", "Erro na chamada: ${e.message} e ${e.cause}")
            }
        }

    }
}