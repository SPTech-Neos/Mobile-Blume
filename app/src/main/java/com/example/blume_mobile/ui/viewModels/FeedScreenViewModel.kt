package com.example.blume_mobile.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blume_mobile.api.retrofit.RetrofitService
import com.example.blume_mobile.data.sampleEstablishments
import com.example.blume_mobile.models.Establishment
import com.example.blume_mobile.models.Product
import com.example.blume_mobile.models.Service
import com.example.blume_mobile.ui.states.FeedScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FeedScreenViewModel: ViewModel() {

    private val apiEstablishment = RetrofitService.getApiEstablishments()
    private val apiProduct = RetrofitService.getApiProducts()
    private val apiService = RetrofitService.getApiServices()
    private val _uiState: MutableStateFlow<FeedScreenUiState> = MutableStateFlow(FeedScreenUiState())
    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update { current ->
            current.copy(
                    onSearch = {
                        _uiState.value = _uiState.value.copy(
                            searchedText = it,
                            searchedBestEstablishments = searchEstablishments(it),
                            searchedBestServices = searchServices(it),
                            searchedBestProducts = searchProducts(it)

                        )
                    },

                onClickFilter = {
                    _uiState.value = _uiState.value.copy(
                        filtered = it
                    )
                }
            )
        }

        getAllEstablishments()
        getAllProducts()
        getAllServices()
        getBestRateds()
    }

    private fun getAllEstablishments() {
        viewModelScope.launch {
            try {
                val getEstablishment = apiEstablishment.getAllActiveEstablishments()

                if(getEstablishment.isSuccessful){
                    if(getEstablishment.body() != null || getEstablishment.body()!!.isNotEmpty()){
                        _uiState.value = _uiState.value.copy(establishments = getEstablishment.body()!!)
                        Log.i("apiEstablishment", "resultado da chamada: ${_uiState.value}")
                    }
                }else {
                    Log.e("apiEstablishment", "resultado da chamada: ${getEstablishment.message()}")
                }

            }catch (e: Exception){
                Log.e("apiEstablishment", "Erro na chamada: ${e.message} e ${e.cause}")
            }

        }
    }

    private fun getBestRateds() {
        viewModelScope.launch {
            try {
                val getEstablishment = apiEstablishment.getBestRateds(5)

                if(getEstablishment.isSuccessful){
                    if(getEstablishment.body() != null || getEstablishment.body()!!.isNotEmpty()){
                        _uiState.value = _uiState.value.copy(bestEstablishments = getEstablishment.body()!!)
                        Log.i("apiEstablishment", "resultado da chamada best rateds: ${_uiState.value}")
                    }
                }else {
                    Log.e("apiEstablishment", "resultado da chamada: ${getEstablishment.message()}")
                }

            }catch (e: Exception){
                Log.e("apiEstablishment", "Erro na chamada: ${e.message} e ${e.cause}")
            }

        }
    }

    private fun getAllProducts(){
        viewModelScope.launch {
            try {
                val getProduct = apiProduct.getAllProducts()

                if(getProduct.isSuccessful){
                    if(getProduct.body() != null || getProduct.body()!!.isNotEmpty()){
                        _uiState.value = _uiState.value.copy(bestProducts = getProduct.body()!!)
                        Log.i("apiProduct", "resultado da chamada: ${_uiState.value}")
                    }
                }else {
                    Log.e("apiProduct", "resultado da chamada: ${getProduct.message()}")
                }

            }catch (e: Exception){
                Log.e("apiProduct", "Erro na chamada: ${e.message} e ${e.cause}")
            }

        }

    }

    private fun getAllServices(){
        viewModelScope.launch {
            try {
                val getService = apiService.getAllServices()

                if(getService.isSuccessful){
                    if(getService.body() != null || getService.body()!!.isNotEmpty()){
                        _uiState.value = _uiState.value.copy(services = getService.body()!!)
                        Log.i("apiService", "resultado da chamada: ${_uiState.value}")
                    }
                }else {
                    Log.e("apiService", "resultado da chamada: ${getService.message()}")
                }

            }catch (e: Exception){
                Log.e("apiService", "Erro na chamada: ${e.message} e ${e.cause}")
            }

        }

    }

    private fun searchEstablishments(text: String): List<Establishment>{
        val searchedByName = mutableListOf<Establishment>()
        val searchedByDescription = mutableListOf<Establishment>()

        if(text.isNotBlank()) {
                _uiState.value.establishments.forEach{ e ->
                    if (e.name.contains(text, ignoreCase = true)){
                        searchedByName.add(e)
                    }

                    if (e.description.contains(text, ignoreCase = true)){
                        if(!searchedByName.contains(e)){
                            searchedByDescription.add(e)
                        }
                    }

                }


        }

        return listOf(
            *searchedByName.toTypedArray(), *searchedByDescription.toTypedArray()
        )
    }

    private fun searchServices(text: String): List<Service>{
        val searchedByName = mutableListOf<Service>()
        val searchedByDescription = mutableListOf<Service>()

        if(text.isNotBlank()){
            searchedByName.addAll(_uiState.value.services.filter { s ->
                s.specification.contains(text, ignoreCase = true)
            })

            searchedByDescription.addAll(_uiState.value.services.filter { s ->
                s.serviceType.name.contains(text, ignoreCase = true)
            })
        }

        return listOf(
            *searchedByName.toTypedArray(), *searchedByDescription.toTypedArray()
        ).distinct()

    }

    private fun searchProducts(text: String): List<Product>{
        val searchedByName = mutableListOf<Product>()
        val searchedByDescription = mutableListOf<Product>()

        if(text.isNotBlank()){
            if(text.isNotBlank()) {
                _uiState.value.bestProducts.forEach{ e ->
                    if (e.name.contains(text, ignoreCase = true)){
                        searchedByName.add(e)
                    }

                    if (e.brand.contains(text, ignoreCase = true)){
                        if(!searchedByName.contains(e)){
                            searchedByDescription.add(e)
                        }
                    }

                }


            }

        }

        return listOf(
            *searchedByName.toTypedArray(), *searchedByDescription.toTypedArray()
        )
    }



}