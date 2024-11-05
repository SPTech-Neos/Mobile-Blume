package com.example.blume_mobile.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blume_mobile.api.retrofit.RetrofitService
import com.example.blume_mobile.data.sampleEstablishments
import com.example.blume_mobile.data.sampleServiceCategories
import com.example.blume_mobile.data.sampleServices
import com.example.blume_mobile.models.Establishment
import com.example.blume_mobile.models.Product
import com.example.blume_mobile.models.Service
import com.example.blume_mobile.ui.states.SearchScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchScreenViewModel : ViewModel() {
    private val feedVM = FeedScreenViewModel()
    private val _uiState: MutableStateFlow<SearchScreenUiState> =
        MutableStateFlow(SearchScreenUiState())
    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update { current ->
            current.copy(
                onSearch = {
                    _uiState.value = _uiState.value.copy(
                        searchedText = it,
                        searchEstablishments = searchEstablishments(it),
                        searchServices = searchServices(it),
                        searchProducts = searchProducts(it)
                    )
                },
                onClickFilter = {
                    _uiState.value = _uiState.value.copy(
                        filtered = it
                    )
                }
            )
        }

        getAllServiceTypes()
    }

    private fun getAllServiceTypes(){
        val apiServiceType = RetrofitService.getApiServiceType()

        viewModelScope.launch {
            try {
                val getService = apiServiceType.getAll()

                if(getService.isSuccessful){
                    if(getService.body() != null || getService.body()!!.isNotEmpty()){
                        _uiState.value = _uiState.value.copy(serviceTypes = getService.body()!!)
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
            feedVM.uiState.value.establishments.forEach{ e ->
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

        if(text.isNotBlank()) {
            feedVM.uiState.value.services.forEach{ s ->
                if (s.specification.contains(text, ignoreCase = true)){
                    searchedByName.add(s)
                }

                if (s.serviceType.name.contains(text, ignoreCase = true)){
                    if(!searchedByName.contains(s)){
                        searchedByDescription.add(s)
                    }
                }

            }


        }

        return listOf(
            *searchedByName.toTypedArray(), *searchedByDescription.toTypedArray()
        )

    }

    private fun searchProducts(text: String): List<Product>{
        val searchedByName = mutableListOf<Product>()
        val searchedByDescription = mutableListOf<Product>()

        if(text.isNotBlank()){
            if(text.isNotBlank()) {
                feedVM.uiState.value.bestProducts.forEach{ e ->
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
