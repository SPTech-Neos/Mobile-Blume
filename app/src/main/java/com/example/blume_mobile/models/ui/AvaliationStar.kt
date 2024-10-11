package com.example.blume_mobile.models.ui

import androidx.compose.ui.graphics.painter.Painter

data class AvaliationStar(
    val selected: Painter?,
    val unselected: Painter?,
    val value: Double?
) {
}