package com.example.blume_mobile.ui.states

import com.example.blume_mobile.models.Establishment

data class FeedScreenUiState(
    val establishments: List<Establishment> = emptyList(),
) {
}