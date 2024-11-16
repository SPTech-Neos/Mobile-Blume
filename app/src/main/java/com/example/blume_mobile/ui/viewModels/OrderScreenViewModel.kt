package com.example.blume_mobile.ui.viewModels

import androidx.lifecycle.ViewModel
import com.example.blume_mobile.ui.states.OrderScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderScreenViewModel: ViewModel() {
    private val _uiState: MutableStateFlow<OrderScreenUiState> = MutableStateFlow(OrderScreenUiState())

    val uiState = _uiState.asStateFlow()

    init {
        _uiState.update { current ->
            current.copy(
                onClickFilter = {
                    _uiState.value = _uiState.value.copy(
                        filtered = it
                    )
                }
            )
        }
    }
}
