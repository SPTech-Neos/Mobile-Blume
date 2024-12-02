package com.example.blume_mobile.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blume_mobile.api.retrofit.RetrofitService
import com.example.blume_mobile.models.Aditum.AditumProduct
import com.example.blume_mobile.models.Aditum.PaymentRequest
import com.example.blume_mobile.models.market.MarketRequest
import com.example.blume_mobile.models.order.OrderRequest
import com.example.blume_mobile.ui.states.ProductDetailsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductDetailsViewModel: ViewModel() {

    val apiOrder = RetrofitService.getApiOrder()
    val apiMarket = RetrofitService.getApiMarket()
    val apiTokenAditum = RetrofitService.getTokenAditum()
    val apiPaymentAditum = RetrofitService.getPaymentAditum()

    private val _uiState: MutableStateFlow<ProductDetailsUiState> = MutableStateFlow(ProductDetailsUiState(""))
    val uiState = _uiState.asStateFlow()

    fun registerOrder(requestOrder: OrderRequest, quatity: Int, productId: Int){

        viewModelScope.launch {
            try {
                val request = apiOrder.registerOrder(request = requestOrder)

                if (request.isSuccessful) {
                    if (request.body() != null) {
                        Log.i("apiOrder", "resultado da chamada: ${request.body()}")
                        registerMarket(MarketRequest(
                            quantity = quatity,
                            fkProduct = productId,
                            fkOrder = request.body()!!.id
                        ))
                    }
                } else {
                    Log.e("apiOrder", "resultado da chamada: ${request.message()}")

                }

            } catch (e: Exception) {

                Log.e("apiOrder", "Erro na chamada: ${e.message} e ${e.cause}")
            }
        }
    }

    fun registerMarket(requestMarket: MarketRequest){
        viewModelScope.launch {
            try {
                val request = apiMarket.registerMarket(request = requestMarket)

                if (request.isSuccessful) {
                    if (request.body() != null) {
                        Log.i("apiMarket", "resultado da chamada: ${request.body()}")

                    }
                } else {
                    Log.e("apiMarket", "resultado da chamada: ${request.message()}")

                }

            } catch (e: Exception) {

                Log.e("apiMarket", "Erro na chamada: ${e.message} e ${e.cause}")
            }
        }

    }

    fun generatePaymentLink(requestAditum: PaymentRequest, token: String){

        viewModelScope.launch {
            try {
                val request = apiPaymentAditum.generatePaymentLink(token = token, requestAditum)

                if (request.isSuccessful) {
                    if (request.body() != null) {
                        Log.i("apiAditumPayment", "resultado da chamada: ${request.body()}")
                        _uiState.value = _uiState.value.copy(
                            aditumUri = "https://blume-dev.aditum.com.br/v2/checkout/" + request.body()!!.id
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

}