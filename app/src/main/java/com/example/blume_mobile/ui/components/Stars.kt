package com.example.blume_mobile.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.Violet300

@Composable
fun Star(
    selected: Boolean = false
){
    val color = if(selected) Violet300 else Gray700

    Icon(Icons.Rounded.Star, contentDescription = "Avaliação", tint = color, modifier = Modifier.size(11.dp))
}