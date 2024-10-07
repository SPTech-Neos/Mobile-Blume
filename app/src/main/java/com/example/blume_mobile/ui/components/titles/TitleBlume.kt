package com.example.blume_mobile.ui.components.titles

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.unica

@Composable
fun TitleBlume(){
    Text("BLUME", style = TextStyle(
        fontFamily = unica,
        fontWeight = FontWeight.Bold,
        fontSize = 50.sp,
        color = Gray700
    ))
}