package com.example.blume_mobile.ui.viewModels

import androidx.lifecycle.ViewModel
import com.example.blume_mobile.data.sampleEstablishments
import com.example.blume_mobile.data.sampleServiceCategories
import com.example.blume_mobile.data.sampleServices
import com.example.blume_mobile.models.Establishment
import com.example.blume_mobile.models.Service
import com.example.blume_mobile.ui.states.SearchScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SearchScreenViewModel : ViewModel() {

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
                    )
                },
                onClickFilter = {
                    _uiState.value = _uiState.value.copy(
                        filtered = it
                    )
                },
                serviceCategories = sampleServiceCategories
            )
        }
    }

    private fun searchEstablishments(text: String): List<Establishment>{
        val searchedByName = mutableListOf<Establishment>()
        val searchedByDescription = mutableListOf<Establishment>()

        if(text.isNotBlank()){
            searchedByName.addAll(sampleEstablishments.filter { e ->
                e.name.contains(text)
            })

            searchedByDescription.addAll(sampleEstablishments.filter { e ->
                e.description.contains(text)
            })
        }

        return listOf(
            *searchedByName.toTypedArray(), *searchedByDescription.toTypedArray()
        ).distinct()

    }

    private fun searchServices(text: String): List<Service>{
        val searchedByName = mutableListOf<Service>()
        val searchedByDescription = mutableListOf<Service>()

        if(text.isNotBlank()){
            searchedByName.addAll(sampleServices.filter { s ->
                s.specification.contains(text)
            })

            searchedByDescription.addAll(sampleServices.filter { s ->
                s.serviceType.name.contains(text)
            })
        }

        return listOf(
            *searchedByName.toTypedArray(), *searchedByDescription.toTypedArray()
        ).distinct()

    }
}
