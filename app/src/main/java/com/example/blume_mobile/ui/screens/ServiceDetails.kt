package com.example.blume_mobile.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.blume_mobile.models.service.Service
import com.example.blume_mobile.ui.theme.Gray700

@Composable
fun ServiceDetails(service: Service, navController: NavController){
    Text(text = service.specification, fontSize = 20.sp, color = Gray700)
}