package com.example.blume_mobile.ui.viewModels

import androidx.lifecycle.ViewModel
import com.example.blume_mobile.ui.states.ProfileScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileScreenViewModel: ViewModel() {
    private val _uiState: MutableStateFlow<ProfileScreenUiState> = MutableStateFlow(ProfileScreenUiState())
    val uiState = _uiState.asStateFlow()

}