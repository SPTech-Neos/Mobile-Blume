package com.example.blume_mobile.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.models.establishment.Establishment
import com.example.blume_mobile.ui.theme.Gray700

@Composable
fun EstablishmentDetails(establishment: Establishment){
    Text(establishment.name, fontSize = 20.sp, color = Gray700)

}