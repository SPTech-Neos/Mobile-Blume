package com.example.blume_mobile.utils.data

import androidx.compose.ui.graphics.painter.Painter

data class NavigationBottomItem(
    val title: String?,
    val selectedIcon: Painter?,
    val unselectedIcon: Painter?,
    val hasNews: Boolean
)
