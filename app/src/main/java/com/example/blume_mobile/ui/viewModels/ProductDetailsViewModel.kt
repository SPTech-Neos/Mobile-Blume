package com.example.blume_mobile.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blume_mobile.api.retrofit.RetrofitService
import com.example.blume_mobile.models.market.MarketRequest
import com.example.blume_mobile.models.order.OrderRequest
import kotlinx.coroutines.launch

class ProductDetailsViewModel: ViewModel() {

    val apiOrder = RetrofitService.getApiOrder()
    val apiMarket = RetrofitService.getApiMarket()

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

}