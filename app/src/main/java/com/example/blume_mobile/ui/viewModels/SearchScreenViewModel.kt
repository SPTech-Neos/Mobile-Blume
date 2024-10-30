package com.example.blume_mobile.ui.viewModels

import androidx.lifecycle.ViewModel
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
                    )
                }
            )
        }
    }
}
